package ca.sheridancollege.midterm_raman.controllers.rest;

import ca.sheridancollege.midterm_raman.model.Person;
import ca.sheridancollege.midterm_raman.model.Pet;
import ca.sheridancollege.midterm_raman.repository.PersonRepository;
import ca.sheridancollege.midterm_raman.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PetController {
    @Autowired
    PetRepository petRepository;
    @Autowired
    PersonRepository personRepository;

    @PostMapping("/persons/{personId}/pets")
    public ResponseEntity<Pet> getPetsBasedOnpersonId(@PathVariable("personId")Long personId,@RequestBody Pet pet){
        Person person = personRepository.findById(personId).get();
        pet.setPerson(person);
        Pet addedPet = petRepository.save(pet);
        return new ResponseEntity<>(addedPet,HttpStatus.OK);
    }
}
