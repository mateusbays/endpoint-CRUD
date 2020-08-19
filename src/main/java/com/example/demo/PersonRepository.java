package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Integer> {

    Person findOneByIdAndDeletedIsFalse(Integer personId);

    Iterable<Person> findAllByDeletedIsFalse();
}