package eu.profinit.education.flightlog.domain.repositories;


import eu.profinit.education.flightlog.domain.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByMemberId(Long memberId);

    List<Person> findAllByPersonTypeOrderByLastNameAscFirstNameAsc(Person.Type personType);
}
