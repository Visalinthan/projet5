package com.openclassroom.projet5.service;

import com.openclassroom.projet5.model.MedicalRecords;
import com.openclassroom.projet5.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public Iterable<MedicalRecords> list(){
        return medicalRecordRepository.findAll();
    }

    public MedicalRecords save(MedicalRecords medicalRecord){
        return medicalRecordRepository.save(medicalRecord);
    }

    public Iterable<MedicalRecords> save(Collection<MedicalRecords> medicalRecords) {
        return medicalRecordRepository.saveAll(medicalRecords);
    }
}
