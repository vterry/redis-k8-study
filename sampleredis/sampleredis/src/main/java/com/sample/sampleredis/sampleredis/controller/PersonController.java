package com.sample.sampleredis.sampleredis.controller;

import com.sample.sampleredis.sampleredis.domain.Person;
import com.sample.sampleredis.sampleredis.service.PersonService;
import com.sample.sampleredis.sampleredis.util.UtilAuthorization;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.RepositoryNameSpaceHandler;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Controller
public class PersonController {

    @Autowired
    public PersonService service;

    @PostMapping("/person")
    public ResponseEntity<String> createPerson(@RequestBody Person person, @RequestHeader HttpHeaders headers) {
        try {
            UtilAuthorization.authorize(headers);
            service.createPerson(person);
            return ResponseEntity.status(HttpStatus.CREATED).body("Person Registered!!!");

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Não autorizado.");
        }
    }

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> findAll(@RequestHeader HttpHeaders headers) {
        try {
            UtilAuthorization.authorize(headers);
            List<Person> persons = service.findAll();
            return ResponseEntity.ok().body(persons);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> findPersonById(@PathVariable("id") Long id, @RequestHeader HttpHeaders headers) {
        try {
            UtilAuthorization.authorize(headers);
            List<Person> persons = service.findAll();
            return ResponseEntity.ok().body(service.findPersonById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }

}
