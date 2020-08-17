package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/person")
public class PersonController {

    @GetMapping
    public Person returnPerson(){
       Person person = new Person();
       person.setName("Jair");
       return person;
    }

    @PostMapping
    public Person insertPerson(@RequestBody  Person person){
        return null;
    }




}
