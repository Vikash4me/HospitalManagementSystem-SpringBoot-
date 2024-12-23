package com.hospital.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.hospital.model.Visitor;

@Service
public class VisitorService {
    private List<Visitor> visitors = new ArrayList<>();
    private long visitorIdCounter = 1;

    private Map<String, String> doctorAssignment = Map.of(
        "Cardiology", "Dr. Smith",
        "Dermatology", "Dr. Allen",
        "General", "Dr. Johnson",
        "Dentist", "Dr. Ankit Raj",
        "Neurology", "Dr. Vikash Kumar"
    );

    public Visitor registerVisitor(Visitor visitor) {
        visitor.setId(visitorIdCounter++);
        visitor.setAssignedDoctor(assignDoctor(visitor.getIllness()));
        visitors.add(visitor);
        return visitor;
    }

    private String assignDoctor(String illness) {
        return doctorAssignment.getOrDefault(illness, "Dr. Default");
    }

    public List<Visitor> getAllVisitors() {
        return visitors;
    }

    public Visitor updateVisitor(long id, Visitor updatedVisitor) {
        for (Visitor visitor : visitors) {
            if (visitor.getId() == id) {
                visitor.setFullName(updatedVisitor.getFullName());
                visitor.setEmail(updatedVisitor.getEmail());
                visitor.setIllness(updatedVisitor.getIllness());
                visitor.setAssignedDoctor(assignDoctor(updatedVisitor.getIllness()));
                return visitor;
            }
        }
        throw new RuntimeException("Visitor not found");
    }

    public void deleteVisitor(long id) {
        visitors.removeIf(visitor -> visitor.getId() == id);
    }
}
