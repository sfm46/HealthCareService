package com.healthcare.ehrservice.service;

import com.healthcare.ehrservice.model.PatientRecord;
import com.healthcare.ehrservice.repository.PatientRecordRepository;

import java.util.List;
import java.util.Optional;

public class PatientRecordService {
    private final PatientRecordRepository repository;

    public PatientRecordService(PatientRecordRepository repository) {
        this.repository = repository;
    }

    public Optional<PatientRecord> getPatientRecord(String patientId) {
        return repository.findByPatientId(patientId);
    }

    public List<PatientRecord> getAllPatientRecords() {
        return repository.findAll();
    }

    public PatientRecord updatePatientRecord(PatientRecord record) {
        return repository.save(record);
    }
}
