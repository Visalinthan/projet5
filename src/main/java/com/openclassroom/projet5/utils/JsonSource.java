package com.openclassroom.projet5.utils;

import com.openclassroom.projet5.model.Address;
import com.openclassroom.projet5.model.FireStations;
import com.openclassroom.projet5.model.Medication;
import com.openclassroom.projet5.model.Person;

import java.util.List;
import java.util.Map;

public class JsonSource {
        private List<Person> persons;
        private List<Address> addresses;
        private Map<String,String> allergies;
        private List<Medication> medications;
        private List<FireStations> fireStations;

        public JsonSource() {
        }

        public List<Person> getPersons() {
                return persons;
        }

        public void setPersons(List<Person> persons) {
                this.persons = persons;
        }

        public List<Address> getAddresses() {
                return addresses;
        }

        public void setAddresses(List<Address> addresses) {
                this.addresses = addresses;
        }


}
