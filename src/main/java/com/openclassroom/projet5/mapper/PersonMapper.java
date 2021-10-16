package com.openclassroom.projet5.mapper;

import com.openclassroom.projet5.dto.MedicalRecordDto;
import com.openclassroom.projet5.dto.PersonDto;
import com.openclassroom.projet5.model.Allergy;
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

    public Person toEntity(PersonDto personDto, List<MedicalRecordDto> medicalRecordDtos) {
        Person person = new Person();

        person.setId(personDto.getId());
        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhone());

        Date birthDate = this.findBirthDateByFirstNameAndLastName(personDto.getFirstName(), personDto.getLastName(), medicalRecordDtos);
        person.setBirthdate(birthDate);
        List<Allergy> allergies = this.findAllergyByFirstNameAndLastName(personDto.getFirstName(), personDto.getLastName(), medicalRecordDtos);
        person.setAllergys(allergies);

        return person;
    }

    private Date findBirthDateByFirstNameAndLastName(String firstName, String lastName, List<MedicalRecordDto> medicalRecordDtos) {
        String s = medicalRecordDtos.stream()
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


    private List<Allergy> findAllergyByFirstNameAndLastName(String firstName, String lastName, List<MedicalRecordDto> medicalRecordDtos){
        List<String> s = medicalRecordDtos.stream()
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

}
