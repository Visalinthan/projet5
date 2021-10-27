package com.openclassroom.projet5.dto;

import lombok.Data;


@Data
public class PersonAddressDto {

    private Long personId;
    private String address;
    private String city;
    private Integer zip;


}
