package eu.profinit.education.flightlog.flight;

import eu.profinit.education.flightlog.IntegrationTestBase;
import eu.profinit.education.flightlog.airplane.Airplane;
import eu.profinit.education.flightlog.person.ClubAirplaneRepository;
import eu.profinit.education.flightlog.person.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class FlightRepositoryTest extends IntegrationTestBase {

    @Autowired
    private FlightRepository testSubject;

    @Autowired
    private ClubAirplaneRepository clubAirplaneRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    void shouldLoadFlights() {

        List<Flight> flights = testSubject.findAll();

        assertEquals(5, flights.size(), "There should be 5 flights");

    }

    @Test
    void shouldLoadGliderFlights() {
        List<Flight> flights = testSubject.findAllByFlightType(Flight.Type.GLIDER);

        assertEquals(2, flights.size(), "There should be 2 glider flights");
    }

    @Test
    void shouldLoadFlightsInTheAir() {
        final Flight flight = Flight.builder()
            .flightType(Flight.Type.TOWPLANE)
            .airplane(Airplane.builder()
                .clubAirplane(clubAirplaneRepository.getReferenceById(1L)).build())
            .pilot(personRepository.getReferenceById(1L))
            .takeoffTime(LocalDateTime.of(2018, 10, 25, 16, 0))
            .build();

        testSubject.saveAndFlush(flight);

        List<Flight> flights = testSubject.findAllByLandingTimeNullOrderByTakeoffTimeAscIdAsc();

        assertEquals(2, flights.size(), "There should be 2 flights");
        assertEquals(5L, flights.get(0).getId().getId().longValue(),
            "Flight with ID 5 started first and should be first");
        assertEquals(flight.getId().getId(), flights.get(1).getId().getId(), "Inserted flight should be second");
    }
}