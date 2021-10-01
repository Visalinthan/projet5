package com.openclassroom.projet5.model;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@AllArgsConstructor
@Embeddable
public class MedicalRecords  {
    private ArrayList<String> medications = new ArrayList<String>();
    private ArrayList<String> allergies = new ArrayList<String>();

    public MedicalRecords (){}

}
