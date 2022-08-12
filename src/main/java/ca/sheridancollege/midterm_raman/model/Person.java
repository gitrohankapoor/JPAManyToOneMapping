package ca.sheridancollege.midterm_raman.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="person")
@Data
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "persongenerator")
    Long id;
    @Column(name = "firstname")
    String firstName;
    @Column(name = "lastname")
    String lastName;
    /*@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id",nullable = false)
    Set<Pet> pets;
    public Set<Pet> getAllPets(){
        return this.pets;
    }

     */
}
