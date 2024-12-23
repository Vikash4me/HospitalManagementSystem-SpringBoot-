package com.hospital.controller;

import com.hospital.model.Complaint;
import com.hospital.service.ComplaintService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintService complaintService;

    // Add a new complaint
    @PostMapping
    public ResponseEntity<String> addComplaint(@RequestBody Complaint complaint) {
        complaintService.addComplaint(complaint);
        return ResponseEntity.ok("Complaint registered successfully. Status: Pending");
    }

    // Get all complaints
    @GetMapping
    public List<Complaint> getAllComplaints() {
        return complaintService.getAllComplaints();
    }

    // Resolve a complaint
    @PutMapping("/{id}/resolve")
    public ResponseEntity<String> resolveComplaint(@PathVariable Long id) {
        boolean resolved = complaintService.resolveComplaint(id);
        if (resolved) {
            return ResponseEntity.ok("Complaint resolved successfully.");
        } else {
            return ResponseEntity.status(404).body("Complaint not found.");
        }
    }

    // Delete a complaint
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComplaint(@PathVariable Long id) {
        boolean deleted = complaintService.deleteComplaint(id);
        if (deleted) {
            return ResponseEntity.ok("Complaint deleted successfully.");
        } else {
            return ResponseEntity.status(404).body("Complaint not found.");
        }
    }
}
