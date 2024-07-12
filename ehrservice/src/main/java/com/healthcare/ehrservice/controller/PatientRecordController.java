package com.healthcare.ehrservice.controller;

import com.healthcare.ehrservice.model.PatientRecord;
import com.healthcare.ehrservice.service.PatientRecordService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

public class PatientRecordController {
    private final PatientRecordService service;

    public PatientRecordController(PatientRecordService service) {
        this.service = service;
    }

    @GetMapping("/getPatientRecord")
    public ResponseEntity<Optional<PatientRecord>> getPatientRecord(@RequestParam String patientId) {
        return ResponseEntity.ok(service.getPatientRecord(patientId));
    }

    @PutMapping("/updatePatientRecord")
    public ResponseEntity<PatientRecord> updatePatientRecord(@RequestBody PatientRecord record) {
        return ResponseEntity.ok(service.updatePatientRecord(record));
    }
}