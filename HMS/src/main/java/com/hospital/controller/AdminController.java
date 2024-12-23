package com.hospital.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Bill;
import com.hospital.model.Visitor;
import com.hospital.service.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private Map<String, String> adminCredentials = Map.of(
        "admin1", "password1",
        "admin2", "password2"
    );

    @Autowired
    private VisitorService visitorService;

    @Autowired
    private BillService billService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> loginDetails) {
        String username = loginDetails.get("username");
        String password = loginDetails.get("password");

        if (adminCredentials.containsKey(username) && adminCredentials.get(username).equals(password)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @GetMapping("/visitors")
    public ResponseEntity<List<Visitor>> viewAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }

    @PutMapping("/visitors/{id}")
    public ResponseEntity<Visitor> updateVisitor(@PathVariable long id, @RequestBody Visitor updatedVisitor) {
        return ResponseEntity.ok(visitorService.updateVisitor(id, updatedVisitor));
    }

    @DeleteMapping("/visitors/{id}")
    public ResponseEntity<String> deleteVisitor(@PathVariable long id) {
        visitorService.deleteVisitor(id);
        return ResponseEntity.ok("Visitor deleted successfully");
    }

    @PostMapping("/generate-bill/{visitorId}")
    public ResponseEntity<Bill> generateBill(
        @PathVariable Long visitorId,
        @RequestParam double roomCharges,
        @RequestParam double pharmacyCharges,
        @RequestParam double diagnosticsCharges) {
        return ResponseEntity.ok(
            billService.generateBill(visitorId, roomCharges, pharmacyCharges, diagnosticsCharges)
        );
    }
}

