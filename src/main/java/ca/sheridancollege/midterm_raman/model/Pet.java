package ca.sheridancollege.midterm_raman.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="pet")
@Data
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "petgenerator")
    Long id;
    @Column(name="name")
    String name;

   @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id",nullable = false)
    Person person;

}
