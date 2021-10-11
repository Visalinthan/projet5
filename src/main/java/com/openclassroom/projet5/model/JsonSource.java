package com.openclassroom.projet5.model;

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
