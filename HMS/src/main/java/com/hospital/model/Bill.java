package com.hospital.model;

public class Bill {
    private long id;
    private long visitorId;
    private double roomCharges;
    private double pharmacyCharges;
    private double diagnosticsCharges;
    private double totalCharges;
	public long getVisitorId() {
		return visitorId;
	}
	public void setVisitorId(long visitorId) {
		this.visitorId = visitorId;
	}
	
	public Bill() {};
	public Bill(long id, long visitorId, double roomCharges, double pharmacyCharges, double diagnosticsCharges,
			double totalCharges) {
		super();
		this.setId(id);
		this.visitorId = visitorId;
		this.roomCharges = roomCharges;
		this.pharmacyCharges = pharmacyCharges;
		this.diagnosticsCharges = diagnosticsCharges;
		this.totalCharges = totalCharges;
	}
	public double getRoomCharges() {
		return roomCharges;
	}
	public void setRoomCharges(double roomCharges) {
		this.roomCharges = roomCharges;
	}
	public double getPharmacyCharges() {
		return pharmacyCharges;
	}
	public void setPharmacyCharges(double pharmacyCharges) {
		this.pharmacyCharges = pharmacyCharges;
	}
	public double getDiagnosticsCharges() {
		return diagnosticsCharges;
	}
	public void setDiagnosticsCharges(double diagnosticsCharges) {
		this.diagnosticsCharges = diagnosticsCharges;
	}
	public double getTotalCharges() {
		return totalCharges;
	}
	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    
}

