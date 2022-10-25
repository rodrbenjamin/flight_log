package eu.profinit.education.flightlog.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import eu.profinit.education.flightlog.dao.ClubDatabaseDao;
import eu.profinit.education.flightlog.dao.User;
import eu.profinit.education.flightlog.domain.entities.Person;
import eu.profinit.education.flightlog.domain.repositories.PersonRepository;
import eu.profinit.education.flightlog.to.AddressTo;
import eu.profinit.education.flightlog.to.PersonTo;

@ExtendWith(MockitoExtension.class)
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private ClubDatabaseDao clubDatabaseDao;

    private PersonServiceImpl testSubject;

    @BeforeEach
    public void setUp() {
        testSubject = new PersonServiceImpl(personRepository, clubDatabaseDao);
    }

    @Test
    void shouldCreateGuest() {
        // prepare data
        PersonTo guestToCreate = PersonTo.builder()
            .firstName("Jan")
            .lastName("Novák")
            .address(AddressTo.builder()
                .street("Tychonova 2")
                .city("Praha 6")
                .postalCode("16000")
                .build())
            .build();

        // mock behaviour
        when(personRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        // call tested method
        Person person = testSubject.getExistingOrCreatePerson(guestToCreate);

        // verify results
        assertEquals(Person.Type.GUEST, person.getPersonType(), "Person type does not match");
        assertEquals(guestToCreate.getFirstName(), person.getFirstName(), "First name does not match");
        assertEquals(guestToCreate.getLastName(), person.getLastName(), "Last name does not match");

        assertEquals(guestToCreate.getAddress().getStreet(), person.getAddress().getStreet(), "Strear does not match");

    }

    @Test
    void shouldReturnExistingClubMember() {
        // prepare data
        PersonTo existingClubMember = PersonTo.builder()
            .memberId(2L)
            .build();

        User testUser = new User(2L, "Kamila", "Spoustová", List.of("PILOT"));
        Person clubMemberFromDd = Person.builder().personType(Person.Type.CLUB_MEMBER).memberId(2L).build();

        // mock behaviour
        when(personRepository.findByMemberId(2L)).thenReturn(Optional.of(clubMemberFromDd));
        when(clubDatabaseDao.getUsers()).thenReturn(List.of(testUser));

        // call tested method
        Person person = testSubject.getExistingOrCreatePerson(existingClubMember);

        // verify results
        assertSame(clubMemberFromDd, person, "Should return prepared instance");
    }

    @Disabled("Test is not implemented")
    @Test
    void shouldCreateNewClubMember() {
        // TODO 7.1: Naimplementujte unit test s pouzitim mocku
    }

}