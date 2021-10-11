package com.openclassroom.projet5.repository;

import com.openclassroom.projet5.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address,Long> {
}
