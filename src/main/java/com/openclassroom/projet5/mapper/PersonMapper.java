package com.openclassroom.projet5.mapper;

import com.openclassroom.projet5.dto.AddressDto;
import com.openclassroom.projet5.dto.MedicalRecordDto;
import com.openclassroom.projet5.dto.PersonDto;
import com.openclassroom.projet5.model.Address;
import com.openclassroom.projet5.model.Allergy;
import com.openclassroom.projet5.model.Medication;
import com.openclassroom.projet5.model.Person;
import org.springframework.stereotype.Component;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class PersonMapper {

    public Person toEntity(PersonDto personDto, List<MedicalRecordDto> medicalRecordDto) {
        Person person = new Person();
        Address address = new Address();

        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhone());

       /* address.setId(address.getId());
        address.setAddress(personDto.getAddress().getAddress());
        address.setCity(personDto.getAddress().getCity());
        address.setZip(personDto.getAddress().getZip());

        person.setAddress(address);*/

        Date birthDate = this.findBirthDateByFirstNameAndLastName(personDto.getFirstName(), personDto.getLastName(), medicalRecordDto);
        person.setBirthdate(birthDate);
        List<Medication> medications = this.findMedicationByFirstNameAndLastName(personDto.getFirstName(), personDto.getLastName(), medicalRecordDto);
        person.setMedications(medications);
        List<Allergy> allergies = this.findAllergyByFirstNameAndLastName(personDto.getFirstName(), personDto.getLastName(), medicalRecordDto);
        person.setAllergys(allergies);

        return person;
    }

    private Date findBirthDateByFirstNameAndLastName(String firstName, String lastName, List<MedicalRecordDto> medicalRecordDto) {
        String s = medicalRecordDto.stream()
                .filter(m -> m.getFirstName().equals(firstName) && m.getLastName().equals(lastName))
                .findFirst()
                .map(MedicalRecordDto::getBirthDate)
                .orElse(null);

        if (s == null) {
            return null;
        }
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(s);
        } catch (ParseException e) {
          return null;
        }
    }


    private List<Allergy> findAllergyByFirstNameAndLastName(String firstName, String lastName, List<MedicalRecordDto> medicalRecordDto){
        List<String> s = medicalRecordDto.stream()
                .filter(m -> m.getFirstName().equals(firstName) && m.getLastName().equals(lastName))
                .findFirst()
                .map(MedicalRecordDto::getAllergies)
                .orElse(null);
        List<Allergy> allergies = new ArrayList<>();
        for (String allergy : s) {
            Allergy allergy1 = new Allergy();
            allergy1.setName(allergy);
            allergies.add(allergy1);
        }
            return allergies;
    }

    private List<Medication> findMedicationByFirstNameAndLastName(String firstName, String lastName, List<MedicalRecordDto> medicalRecordDto){
        List<String> s = medicalRecordDto.stream()
                .filter(m -> m.getFirstName().equals(firstName) && m.getLastName().equals(lastName))
                .findFirst()
                .map(MedicalRecordDto::getMedications)
                .orElse(null);
        List<Medication> medications = new ArrayList<>();
        for (String medication : s) {
            Medication medication1 = new Medication();
            String[] m = medication.split(":",0);
            medication1.setName(m[0]);
            medication1.setDosage(m[1]);

            medications.add(medication1);
        }
        return medications;

    }

}
