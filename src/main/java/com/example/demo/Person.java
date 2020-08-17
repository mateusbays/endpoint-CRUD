package com.example.demo;


import javax.persistence.Id;

public class Person {

    @Id
    private Integer personId;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getPersonId(){
        return personId;
    }

}
