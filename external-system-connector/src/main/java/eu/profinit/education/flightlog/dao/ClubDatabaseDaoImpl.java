package eu.profinit.education.flightlog.dao;

import eu.profinit.education.flightlog.exceptions.ExternalSystemException;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

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
            userList = null;
            throw new NotImplementedException("Integration is not implemented. Use stub implementation instead");
        } catch (RuntimeException e) {
            throw new ExternalSystemException("Cannot get users from Club database. URL: {}. Call resulted in exception.", e, clubDbBaseUrl);
        }
        //return Arrays.asList(userList);
    }
}
