package com.openclassroom.projet5.utils;

import com.openclassroom.projet5.dto.MedicalRecordDto;
import com.openclassroom.projet5.dto.PersonDto;

import java.util.List;

public class JsonSource {
        private List<PersonDto> persons;
        private List<MedicalRecordDto> medicalrecords;
       // private List<AddressDto> addresses;
      //  private Map<String,String> allergies;
      //  private List<Medication> medications;
       // private List<FireStations> fireStations;

        public JsonSource() {
        }

        public List<PersonDto> getPersons() {
                return persons;
        }

        public void setPersons(List<PersonDto> persons) {
                this.persons = persons;
        }

        public List<MedicalRecordDto> getMedicalrecords() {
                return medicalrecords;
        }

        public void setMedicalrecords(List<MedicalRecordDto> medicalrecords) {
                this.medicalrecords = medicalrecords;
        }
}
