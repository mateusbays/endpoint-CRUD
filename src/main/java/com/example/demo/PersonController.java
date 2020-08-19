package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/v1/persons0")
    public Iterable<Person> getAllUsers() {
        // This returns a JSON or XML with the users
        return personRepository.findAllByDeletedIsFalse();
    }

    @PostMapping("/v1/persons")
    public String insertPerson(@RequestParam String name, @RequestParam Integer personId) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person person = new Person();
        person.setName(name);
        person.setId(personId);
        personRepository.save(person);
        return "Saved";
    }

    @PutMapping("/v1/persons/{id}")
    public String updatePerson(@RequestBody Person person, @RequestParam("id") Integer id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person personSave = personRepository.findOneByIdAndDeletedIsFalse(id);
        System.out.println("Pessoa encontrado.");
        personSave.setName(person.getName());
        personRepository.save(personSave);
        return "saved";
    }

    @DeleteMapping("/v1/persons/")
    public String deletePerson(@RequestParam("id") Integer id) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Person personDelete = personRepository.findOneByIdAndDeletedIsFalse(id);
        System.out.println("Pessoa encontrado.");
        personDelete.setDeleted(true);
        personRepository.save(personDelete);
        return "saved";
    }

}
