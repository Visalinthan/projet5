package com.openclassroom.projet5.service;

import com.openclassroom.projet5.model.Person;
import com.openclassroom.projet5.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Iterable<Person> list(){
        return personRepository.findAll();
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public Iterable<Person> save(Collection<Person> persons) {
        return personRepository.saveAll(persons);
    }
}
