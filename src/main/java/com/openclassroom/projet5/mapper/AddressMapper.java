package com.openclassroom.projet5.mapper;

import com.openclassroom.projet5.dto.AddressDto;
import com.openclassroom.projet5.dto.PersonDto;
import com.openclassroom.projet5.model.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public Address toEntity(AddressDto addressDto, PersonDto personDto){

        Address address = new Address();

        address.setId(addressDto.getId());
        address.setAddress(personDto.getAddress().getAddress());
        address.setZip(personDto.getAddress().getZip());
        address.setCity(personDto.getAddress().getCity());

        return address;
    }

}
