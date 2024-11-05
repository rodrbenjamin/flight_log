package eu.profinit.education.flightlog.person;

import java.util.List;

public interface PersonService {

    List<PersonTo> getClubMembers();

    Person getExistingOrCreatePerson(PersonTo personTo);
}