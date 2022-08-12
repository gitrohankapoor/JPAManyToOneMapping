package ca.sheridancollege.midterm_raman.controllers.rest;

import ca.sheridancollege.midterm_raman.exception.RecordNotFoundException;
import ca.sheridancollege.midterm_raman.model.Person;
import ca.sheridancollege.midterm_raman.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PerosnController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/persons")
    public ResponseEntity<List<Person>> getAllPersons(){
        List<Person> personList = personRepository.findAll();
        if(personList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok().body(personList);
    }

    @PostMapping("/persons")
    public ResponseEntity<Person> addPerson(@RequestBody Person person){
        Person addedPerson = personRepository.save(person);
        return new ResponseEntity(addedPerson, HttpStatus.CREATED);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable("id") Long id, @RequestBody Person person) throws Exception {
        Person findPerson = personRepository.getById(id);
        if(person==null){
            throw new RecordNotFoundException("Record Not Found for "+id);
        }


            person.setFirstName(findPerson.getFirstName());
            person.setLastName(findPerson.getLastName());
            Person addedPerson = personRepository.save(findPerson);
            return new ResponseEntity<>(addedPerson,HttpStatus.OK);

    }

}
