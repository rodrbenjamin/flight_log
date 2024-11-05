package eu.profinit.education.flightlog.report;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import eu.profinit.education.flightlog.IntegrationTestBase;
import eu.profinit.education.flightlog.common.FileUtils;
import org.springframework.test.context.ActiveProfiles;

class CsvExportServiceTest extends IntegrationTestBase {

    @Autowired
    private CsvExportService testSubject;

    // TODO 6.1: Odstrante anotaci @Disabled, aby se test vykonaval
    @Disabled("Tested method is not implemented yet")
    @Test
    void testCSVExport() throws IOException, URISyntaxException {
        FileExportTo fileExportTo = testSubject.getAllFlightsAsCsv();

        // TODO 6.2: zkontrolujte obsah CSV
        // Tip: Využijte třídu FileUtils
    }


}