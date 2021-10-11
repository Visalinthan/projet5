package com.openclassroom.projet5.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @Temporal(TemporalType.DATE)
    private Date birthdate;

   // @JoinColumn(name = "address_id")
   // @ManyToOne
    private String address;

 //   @Embedded
 //   private MedicalRecords medicalRecords;

}
