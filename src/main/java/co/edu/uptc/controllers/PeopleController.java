package co.edu.uptc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.models.PersonModel;
import co.edu.uptc.services.PeopleManagerService;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/people")
public class PeopleController {


    @Autowired
    PeopleManagerService peopleManagerService;
    
    @GetMapping("/all")
    public ArrayList<PersonModel> getAll() {
        return peopleManagerService.getPeople();
    }
    
  @PostMapping("/add")
  public PersonModel addPerson(@RequestBody PersonModel person) {
       peopleManagerService.addPerson(person);       
      return person;
  }
  
  @DeleteMapping("/{id}")
  public PersonModel deletePerson(@PathVariable Long id) {
    PersonModel personModel = peopleManagerService.deletePerson(id);      
    return personModel;
  }

}