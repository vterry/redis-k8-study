package com.sample.sampleredis.sampleredis.repository;

import com.sample.sampleredis.sampleredis.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
    public Person findPersonById(Long id);
}
