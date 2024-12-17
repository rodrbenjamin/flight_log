package eu.profinit.education.flightlog.person;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import eu.profinit.education.flightlog.person.PersonServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import eu.profinit.education.flightlog.person.user.ClubDatabaseDao;
import eu.profinit.education.flightlog.person.user.User;
import eu.profinit.education.flightlog.person.Person;
import eu.profinit.education.flightlog.person.PersonRepository;
import eu.profinit.education.flightlog.person.AddressTo;
import eu.profinit.education.flightlog.person.PersonTo;

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

    @Test
    void shouldCreateNewClubMember() {
        Long newClubMemberId = 2L;
        String firstName = "Jan";
        String lastName = "Bajer";

        PersonTo clubMember = PersonTo.builder()
            .firstName(firstName)
            .lastName(lastName)
            .memberId(newClubMemberId)
            .address(AddressTo.builder()
                .street("Tychonova 2")
                .city("Praha 6")
                .postalCode("16000")
                .build())
            .build();

        User user = new User(newClubMemberId, firstName, lastName, List.of("ROLE_PILOT"));

        // mock behaviour
        when(personRepository.findByMemberId(newClubMemberId)).thenReturn(Optional.empty());
        when(personRepository.save(any())).thenAnswer(AdditionalAnswers.returnsFirstArg());
        when(clubDatabaseDao.getUsers()).thenReturn(List.of(user));

        // call tested method
        Person result = testSubject.getExistingOrCreatePerson(clubMember);
        // verify results
        assertEquals(Person.Type.CLUB_MEMBER, result.getPersonType(), "Person type does not match");
        assertEquals(clubMember.getFirstName(), result.getFirstName(), "First name does not match");
        assertEquals(clubMember.getLastName(), result.getLastName(), "Last name does not match");
    }

}