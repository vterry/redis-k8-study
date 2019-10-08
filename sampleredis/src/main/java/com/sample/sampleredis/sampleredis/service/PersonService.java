package com.sample.sampleredis.sampleredis.service;

import com.sample.sampleredis.sampleredis.domain.Person;
import com.sample.sampleredis.sampleredis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    public PersonRepository repository;

    @Cacheable(cacheNames = "Person", key = "#id")
    public Person findPersonById(Long id) {
        return repository.findPersonById(id);
    }

    @Cacheable(cacheNames = "Person", key="#root.method.name")
    public List<Person> findAll(){
        return repository.findAll();
    }

    @CacheEvict(cacheNames = "Person", allEntries = true)
    public Person createPerson(Person person) {
        return repository.save(person);
    }

}
