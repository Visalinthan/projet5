package com.openclassroom.projet5.repository;

import com.openclassroom.projet5.model.FireStations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FireStationRepository extends CrudRepository<FireStations,Long> {
}
