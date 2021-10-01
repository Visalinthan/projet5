package com.openclassroom.projet5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
public class Address {
    private String address;
    private String city;
    private int zip;

}
