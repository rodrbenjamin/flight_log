package eu.profinit.education.flightlog.service;

import eu.profinit.education.flightlog.IntegrationTestConfig;
import eu.profinit.education.flightlog.to.FileExportTo;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = IntegrationTestConfig.class)
@Transactional
@TestPropertySource(
    locations = "classpath:application-integrationtest.properties")
public class CsvExportServiceTest {

    @Autowired
    private CsvExportService testSubject;

    // TODO 6.1: Odstrante anotaci @Ignore, aby se test vykonaval
    @Ignore("Tested method is not implemented yet")
    @Test
    public void testCSVExport() {
        FileExportTo allFlightsAsCsv = testSubject.getAllFlightsAsCsv();

        // TODO 6.2: zkontrolujte obsah CSV
    }
}