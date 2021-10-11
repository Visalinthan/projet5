package com.openclassroom.projet5.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;


import javax.persistence.*;

@Data
@AllArgsConstructor
@Entity
public class MedicalRecords  {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToMany
    private List<Medication> medications = new ArrayList<>();

    @ManyToMany
    private List<Allergy> allergies = new ArrayList<>();

    public MedicalRecords (){}

}
