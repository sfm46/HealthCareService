package com.healthcare.ehrservice.repository;

import com.healthcare.ehrservice.model.PatientRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRecordRepository extends JpaRepository<PatientRecord, Long> {
    Optional<PatientRecord> findByPatientId(String patientId);
}
