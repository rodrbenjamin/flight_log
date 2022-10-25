package eu.profinit.education.flightlog.service;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.profinit.education.flightlog.AbstractIntegrationTest;
import eu.profinit.education.flightlog.to.FileExportTo;

public class CsvExportServiceTest extends AbstractIntegrationTest {

    @Autowired
    private CsvExportService testSubject;

    // TODO 6.1: Odstrante anotaci @Disabled, aby se test vykonaval
    @Disabled("Tested method is not implemented yet")
    @Test
    public void testCSVExport() throws IOException, URISyntaxException {
        FileExportTo fileExportTo = testSubject.getAllFlightsAsCsv();

        // TODO 6.2: zkontrolujte obsah CSV
        // Tip: Využijte třídu FileUtils
    }


}