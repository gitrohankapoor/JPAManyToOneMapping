package ca.sheridancollege.midterm_raman.repository;

import ca.sheridancollege.midterm_raman.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
