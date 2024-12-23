package com.hospital.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hospital.model.Bill;

@Service
public class BillService {
    private List<Bill> bills = new ArrayList<>();
    private long billIdCounter = 1;

    public Bill generateBill(Long visitorId, double roomCharges, double pharmacyCharges, double diagnosticsCharges) {
        Bill bill = new Bill();
        bill.setId(billIdCounter++);
        bill.setVisitorId(visitorId);
        bill.setRoomCharges(roomCharges);
        bill.setPharmacyCharges(pharmacyCharges);
        bill.setDiagnosticsCharges(diagnosticsCharges);
        bill.setTotalCharges(roomCharges + pharmacyCharges + diagnosticsCharges);
        bills.add(bill);
        return bill;
    }

    public List<Bill> getAllBills() {
        return bills;
    }
}

