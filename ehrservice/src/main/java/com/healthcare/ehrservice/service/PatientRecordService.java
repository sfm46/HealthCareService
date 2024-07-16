package com.healthcare.ehrservice.service;

import com.healthcare.ehrservice.model.*;
import com.healthcare.ehrservice.repository.PatientRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientRecordService {

    @Autowired
    private PatientRecordRepository repository;

    public PatientRecord getPatientRecord(Long patientId) {
        return repository.findByPatientId(patientId);
    }

    public PatientRecord updatePatientRecord(PatientRecord record) {
        return repository.save(record);
    }

    public List<PatientRecord> getAllPatientRecords() {
        return repository.findAll();
    }

    public PatientRecord createPatientRecord(PatientRecord record) {
        // Set the patientRecord in each LabData instance
        if (record.getLabDataList() != null) {
            for (LabData labData : record.getLabDataList()) {
                labData.setPatientRecord(record);
            }
        }
        if (record.getMedicineDataList() != null) {
            for (MedicineData medicineData : record.getMedicineDataList()) {
                medicineData.setPatientRecord(record);
            }
        }
        if (record.getDiagnoses() != null) {
            for (Diagnosis diagnosis : record.getDiagnoses()) {
                diagnosis.setPatientRecord(record);
            }
        }
        if (record.getTreatmentHistories() != null) {
            for (TreatmentHistory treatmentHistory : record.getTreatmentHistories()) {
                treatmentHistory.setPatientRecord(record);
            }
        }
        return repository.save(record);
    }

    public void deletePatientRecord(Long id) {
        repository.deleteById(id);
    }

}