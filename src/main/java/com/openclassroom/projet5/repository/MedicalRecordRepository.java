package com.openclassroom.projet5.repository;

import com.openclassroom.projet5.model.MedicalRecords;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends CrudRepository<MedicalRecords,Long> {
}
