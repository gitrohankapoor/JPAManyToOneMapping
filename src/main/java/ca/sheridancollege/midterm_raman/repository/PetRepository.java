package ca.sheridancollege.midterm_raman.repository;


import ca.sheridancollege.midterm_raman.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet,Long> {
     List<Pet> findByPersonId(Long personId);
}
