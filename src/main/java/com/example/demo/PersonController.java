package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public String insertPerson(@RequestBody Person person) {

        Person personSave = new Person();
        personSave.setName(person.getName());
        personRepository.save(personSave);
        return "Saved";
    }

    @PutMapping("/v1/persons/{id}")
    public String updatePerson(@RequestBody Person person, @PathVariable Integer id) {

        Person personSave = personRepository.findOneByIdAndDeletedIsFalse(id);
        System.out.println("Pessoa encontrado.");
        personSave.setName(person.getName());
        personRepository.save(personSave);
        return "saved";
    }

    @DeleteMapping("/v1/persons/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {

        Person personDelete = personRepository.findOneByIdAndDeletedIsFalse(id);
        System.out.println("Pessoa encontrado.");
        personDelete.setDeleted(true);
        personRepository.save(personDelete);
        return "saved";
    }

}
