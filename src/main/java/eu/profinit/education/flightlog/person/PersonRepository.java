package eu.profinit.education.flightlog.person;


import eu.profinit.education.flightlog.person.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByMemberId(Long memberId);

    List<Person> findAllByPersonTypeOrderByLastNameAscFirstNameAsc(Person.Type personType);
}