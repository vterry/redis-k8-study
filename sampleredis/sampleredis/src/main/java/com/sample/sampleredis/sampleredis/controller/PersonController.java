package com.sample.sampleredis.sampleredis.controller;

import com.sample.sampleredis.sampleredis.domain.Person;
import com.sample.sampleredis.sampleredis.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    public PersonService service;

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody Person person) {
        service.createPerson(person);
        return ResponseEntity.status(HttpStatus.CREATED).body("Person Registered!!!");
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> findAll() {
        List<Person> persons = service.findAll();
        return ResponseEntity.ok().body(persons);
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(service.findPersonById(id));
    }

}
