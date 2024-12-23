package com.hospital.controller;
import com.hospital.model.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
    @Autowired
    private BillService billService;
    
    @PostMapping("/addBill")
    public ResponseEntity<Bill> generateBill(@RequestParam Long visitorId,
                                             @RequestParam double roomCharges,
                                             @RequestParam double pharmacyCharges,
                                             @RequestParam double diagnosticCharges) {
        Bill bill = billService.generateBill(visitorId, roomCharges, pharmacyCharges, diagnosticCharges);
        return ResponseEntity.ok(bill);
    }
    
    @GetMapping
    public ResponseEntity<List<Bill>> getAllBills() {
        return ResponseEntity.ok(billService.getAllBills());
    }
}

