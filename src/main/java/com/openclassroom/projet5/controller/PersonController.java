package com.openclassroom.projet5.controller;

import com.openclassroom.projet5.model.Person;
import com.openclassroom.projet5.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public Iterable<Person> list(){
        return personService.list();
    }

}
