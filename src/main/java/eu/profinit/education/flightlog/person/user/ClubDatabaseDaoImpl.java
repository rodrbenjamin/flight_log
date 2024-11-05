package eu.profinit.education.flightlog.person.user;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import eu.profinit.education.flightlog.common.exceptions.ExternalSystemException;

@Component
@Profile("!stub")
public class ClubDatabaseDaoImpl implements ClubDatabaseDao {

    private final RestTemplate restTemplate;
    private final String clubDbBaseUrl;

    // TODO 5.2: načtěte property integration.clubDb.baseUrl z application.properties (hint: CsvExportServiceImpl)
    public ClubDatabaseDaoImpl() {
        this.restTemplate = new RestTemplate();
       this.clubDbBaseUrl = null;
    }

    @Override
    public List<User> getUsers() {
        User[] userList;
        try {
            // TODO 5.3: implementujte tělo volání endpointu ClubDB pomocí REST template
            userList = new User[]{};

        } catch (RuntimeException e) {
            throw new ExternalSystemException("Cannot get users from Club database. URL: {}. Call resulted in exception.", e, clubDbBaseUrl);
        }
        return Arrays.asList(userList);
    }
}