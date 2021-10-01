package com.openclassroom.projet5.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String firstName, lastName,email;
    private String zip,phone;
    private Date birthdate;

    @Embedded
    private Address address;


    public Person() {
;
    }

}
