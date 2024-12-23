package com.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital.model.Visitor;
import com.hospital.service.VisitorService;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @PostMapping("/register")
    public ResponseEntity<Visitor> register(@RequestBody Visitor visitor) {
        return ResponseEntity.ok(visitorService.registerVisitor(visitor));
    }

    @GetMapping
    public ResponseEntity<List<Visitor>> getAllVisitors() {
        return ResponseEntity.ok(visitorService.getAllVisitors());
    }
}

