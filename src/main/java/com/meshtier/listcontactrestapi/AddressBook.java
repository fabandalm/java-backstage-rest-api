package com.meshtier.listcontactrestapi;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressBook {

    ConcurrentMap<String, Person> contacts = new ConcurrentHashMap<String, Person>();

    @GetMapping("/")
    public List<Person> getAllPersons(){

        return contacts.values().stream().toList();
    }

    @PostMapping("/")
    public Person addPerson(@RequestBody Person person){
        contacts.put(person.getId(), person);
        return person;
    }

}
