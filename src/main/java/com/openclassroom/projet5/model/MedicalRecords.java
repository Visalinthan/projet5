package com.openclassroom.projet5.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class MedicalRecords  {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private ArrayList<String> medications = new ArrayList<String>();
    private ArrayList<String> allergies = new ArrayList<String>();

    @Embedded
    private Person person;

}
