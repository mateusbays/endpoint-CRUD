package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/v1/persons")
    public Iterable<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personRepository.findAllByDeletedIsFalse();
    }

    @PostMapping("/v1/persons")
    public Person insertPerson(@RequestBody Person person) {
            Person personSave = new Person();
            personSave.setName(person.getName());
            return personRepository.save(personSave);
    }

    @PutMapping("/v1/persons/{id}")
    public Person updatePerson(@RequestBody Person person, @PathVariable Integer id)  {
            Person personSave = personRepository.findOneByIdAndDeletedIsFalse(id);
            personSave.setName(person.getName());
            return personRepository.save(personSave);
    }

    @DeleteMapping("/v1/persons/{id}")
    public Person deletePerson(@PathVariable("id") Integer id) {
            Person personDelete = personRepository.findOneByIdAndDeletedIsFalse(id);
            System.out.println("Pessoa encontrado.");
            personDelete.setDeleted(true);
            return personRepository.save(personDelete);
    }

}
