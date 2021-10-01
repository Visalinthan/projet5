package com.openclassroom.projet5.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class FireStations {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;

    @Embedded
    private Address address;

    private int station;


}
