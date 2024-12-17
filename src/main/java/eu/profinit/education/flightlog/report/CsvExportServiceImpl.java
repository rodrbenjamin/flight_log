package eu.profinit.education.flightlog.report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import eu.profinit.education.flightlog.flight.FlightTo;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import eu.profinit.education.flightlog.flight.Flight;
import eu.profinit.education.flightlog.flight.FlightRepository;
import eu.profinit.education.flightlog.common.exceptions.FlightLogException;

@Service
public class CsvExportServiceImpl implements CsvExportService {

    private static final String DATE_PATTERN = "dd.MM.yyyy HH:mm:ss";
    private final FlightRepository flightRepository;

    private final String fileName;

    public CsvExportServiceImpl(FlightRepository flightRepository, @Value("${csv.export.flight.fileName}") String fileName) {
        this.flightRepository = flightRepository;
        this.fileName = fileName;
    }

    @Override
    public FileExportTo getAllFlightsAsCsv() {
        FileExportTo fileExportTo;
        List<Flight> flights = flightRepository.findAll(
            Sort.by(Sort.Order.asc("takeoffTime"),
                Sort.Order.asc("id")));

        try (
            ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
            Writer printWriter = new OutputStreamWriter(byteOutputStream, (StandardCharsets.UTF_8));
            CSVPrinter csvExport = new CSVPrinter(printWriter, CSVFormat.DEFAULT)
        ) {
            csvExport.printRecord("sep=,");
            csvExport.printRecord("FlightID","TakeoffTime","LandingTime","Immatriculation","Type","Pilot","Copilot","Task","TowplaneID","GliderID");
            for (Flight flight : flights) {
                FlightTo flightTo = FlightTo.fromEntity(flight);

                String pilot = flightTo.getPilot().getFirstName() + " " + flightTo.getPilot().getLastName();
                String copilot = (flightTo.getCopilot() == null) ? "" : flightTo.getCopilot().getFirstName() + " " + flightTo.getCopilot().getLastName();
                String towplaneID = (flight.getTowplaneFlight() == null) ? "" : FlightTo.fromEntity(flight.getTowplaneFlight()).getId().toString();
                String gliderID = (flight.getGliderFlight() == null) ? "" : FlightTo.fromEntity(flight.getGliderFlight()).getId().toString();
                csvExport.printRecord(
                    flightTo.getId(),
                    formatDateTime(flightTo.getTakeoffTime()),
                    formatDateTime(flightTo.getLandingTime()),
                    flightTo.getAirplane().getImmatriculation(),
                    flightTo.getAirplane().getType(),
                    pilot,
                    copilot,
                    flightTo.getTask(),
                    towplaneID,
                    gliderID
                );
            }
            csvExport.flush();
            fileExportTo = new FileExportTo(fileName, MediaType.TEXT_PLAIN,"UTF-8",byteOutputStream.toByteArray());

        } catch (IOException exception) {
            throw new FlightLogException("Error when parsing flights into CSV", exception);
        }
        return fileExportTo;
    }

    private String formatDateTime(LocalDateTime dateTime){
        return dateTime==null ? null : DateTimeFormatter.ofPattern(DATE_PATTERN).format(dateTime);
    }
}