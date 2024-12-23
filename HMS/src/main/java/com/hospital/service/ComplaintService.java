package com.hospital.service;

import com.hospital.model.Complaint;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ComplaintService {

    private List<Complaint> complaints = new ArrayList<>();

    // Add a new complaint
    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }

    // Get all complaints
    public List<Complaint> getAllComplaints() {
        return complaints;
    }

    // Resolve a complaint
    public boolean resolveComplaint(Long id) {
        for (Complaint complaint : complaints) {
            if (complaint.getId().equals(id)) {
                complaint.setStatus("Resolved");
                return true;
            }
        }
        return false;
    }

    // Delete a complaint
    public boolean deleteComplaint(Long id) {
        Iterator<Complaint> iterator = complaints.iterator();
        while (iterator.hasNext()) {
            Complaint complaint = iterator.next();
            if (complaint.getId().equals(id)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
