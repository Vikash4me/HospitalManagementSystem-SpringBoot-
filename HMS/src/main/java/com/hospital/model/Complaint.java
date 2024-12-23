package com.hospital.model;

public class Complaint {
    private Long id;
    private Long visitorId;
    private String description;
    private String status; // Pending or Resolved

    public Complaint(Long id, Long visitorId, String description) {
        this.id = id;
        this.visitorId = visitorId;
        this.description = description;
        this.status = "Pending"; // Default status when a complaint is created
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Long visitorId) {
        this.visitorId = visitorId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
