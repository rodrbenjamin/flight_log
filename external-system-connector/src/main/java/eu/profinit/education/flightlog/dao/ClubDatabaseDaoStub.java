package eu.profinit.education.flightlog.dao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
@Profile("stub")
public class ClubDatabaseDaoStub implements ClubDatabaseDao {
    @Override
    public List<User> getUsers() {
        return Arrays.asList(
            new User(1L, "Kamila", "Spoustová", Arrays.asList("PILOT")),
            new User(2L, "Naděžda", "Pavelková", Arrays.asList("PILOT")),
            new User(3L, "Silvie", "Hronová", Arrays.asList("PILOT")),
            new User(9L, "Miloš", "Korbel", Arrays.asList("PILOT", "BACKOFFICE")),
            new User(10L, "Petr", "Hrubec", Arrays.asList("PILOT", "BACKOFFICE")),
            new User(13L, "Michal", "Vyvlečka", Arrays.asList("BACKOFFICE"))
        );
    }
}
