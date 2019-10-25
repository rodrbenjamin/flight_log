package eu.profinit.education.flightlog.service;

import eu.profinit.education.flightlog.domain.entities.Person;
import eu.profinit.education.flightlog.to.PersonTo;

import java.util.List;

public interface PersonService {

    List<PersonTo> getClubMembers();

    Person getExistingOrCreatePerson(PersonTo personTo);
}
