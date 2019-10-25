package eu.profinit.education.flightlog.domain.repositories;


import eu.profinit.education.flightlog.IntegrationTestConfig;
import eu.profinit.education.flightlog.domain.entities.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfig.class)
@Transactional
@TestPropertySource(
    locations = "classpath:application-integrationtest.properties")
public class PersonRepositoryTest {

    @Autowired
    private PersonRepository testSubject;

    private Long testClubMemberId = 1L;

    @Test
    public void shouldFindClubMemberByMemberId() {
        Optional<Person> maybeClubMember = testSubject.findByMemberId(testClubMemberId);

        assertTrue("Club member should be found", maybeClubMember.isPresent());
        assertEquals("Member ID should be 1", testClubMemberId, maybeClubMember.get().getMemberId());

    }
}