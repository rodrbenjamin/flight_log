package eu.profinit.education.flightlog.flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import eu.profinit.education.flightlog.person.PersonService;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import eu.profinit.education.flightlog.common.Clock;
import eu.profinit.education.flightlog.airplane.Airplane;
import eu.profinit.education.flightlog.person.Person;
import eu.profinit.education.flightlog.person.ClubAirplaneRepository;
import eu.profinit.education.flightlog.common.exceptions.NotFoundException;
import eu.profinit.education.flightlog.common.exceptions.ValidationException;
import eu.profinit.education.flightlog.airplane.AirplaneTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FlightServiceImpl implements FlightService {

    private static final int MAX_RECORDS_IN_GUI = 2000;

    private final FlightRepository flightRepository;
    private final ClubAirplaneRepository clubAirplaneRepository;
    private final Clock clock;

    private final PersonService personService;

    @Override
    public void takeoff(FlightTakeoffTo flightStart) {
        if (flightStart.getTakeoffTime() == null) {
            throw new ValidationException("Takeoff time is null.");
        }
        Flight towPlaneFlight = createTowPlaneFlight(flightStart);
        Flight gliderFlight = createGliderFlight(flightStart);
        if (gliderFlight != null) {
            towPlaneFlight.setGliderFlight(gliderFlight);
            flightRepository.save(towPlaneFlight);
            gliderFlight.setTowplaneFlight(towPlaneFlight);
            flightRepository.save(gliderFlight);
        }
    }

    private Flight createTowPlaneFlight(FlightTakeoffTo flightStart) {
        if (flightStart.getTowplane() == null) {
            throw new ValidationException("Towplane must be set.");
        }
        Airplane airplane = getAirplane(flightStart.getTowplane().getAirplane());

        Person pilot = personService.getExistingOrCreatePerson(flightStart.getTowplane().getPilot());
        Person copilot = personService.getExistingOrCreatePerson(flightStart.getTowplane().getCopilot());

        Flight flight = new Flight(Flight.Type.TOWPLANE, Task.TOWPLANE_TASK, flightStart.getTakeoffTime(), airplane, pilot, copilot, flightStart.getTowplane().getNote());
        return flightRepository.save(flight);
    }

    private Flight createGliderFlight(FlightTakeoffTo flightStart) {
        if (flightStart.getGlider() == null) {
            return null;
        }
        Airplane airplane = getAirplane(flightStart.getGlider().getAirplane());

        Person pilot = personService.getExistingOrCreatePerson(flightStart.getGlider().getPilot());
        Person copilot = personService.getExistingOrCreatePerson(flightStart.getGlider().getCopilot());

        Flight flight = new Flight(Flight.Type.GLIDER, Task.of(flightStart.getTask()), flightStart.getTakeoffTime(), airplane, pilot, copilot, flightStart.getGlider().getNote());
        return flightRepository.save(flight);
    }

    private Airplane getAirplane(AirplaneTo airplaneTo) {
        if (airplaneTo.getId() != null) {
            return Airplane.clubAirplane(clubAirplaneRepository.findById(airplaneTo.getId()).orElseThrow(() -> new IllegalArgumentException("Club airplane does not exists")));
        } else {
            return Airplane.guestAirplane(airplaneTo.getImmatriculation(), airplaneTo.getType());
        }
    }

    @Override
    public void land(FlightId flightId, LocalDateTime landingTime) {
        Assert.notNull(flightId, "Flight ID cannot be null");
        if (landingTime == null) {
            landingTime = clock.now();
        }
        Flight flight = flightRepository.findById(flightId.getId()).orElseThrow(() -> new NotFoundException("Flight with ID {} does not exists.", flightId));
        if (!landingTime.isAfter(flight.getTakeoffTime())) {
            throw new ValidationException("Given landing time {} cannot be before takeoffTime {}", landingTime, flight.getTakeoffTime());
        }
        if (flight.getLandingTime() != null) {
            throw new ValidationException("Flight with ID {} has already landed", flight.getId());
        }

        flight.setLandingTime(landingTime);
        flightRepository.save(flight);
    }

    @Transactional(readOnly = true)
    @Override
    public List<FlightTo> getFlightsInTheAir() {
        List<Flight> flightsInTheAir = flightRepository.findAllByLandingTimeNullOrderByTakeoffTimeAscIdAsc();

        List<FlightTo> fligtsTo = flightsInTheAir.stream().map(FlightTo::fromEntity).toList();

        return fligtsTo;
    }

    @Override
    public List<FlightTuppleTo> getFlightsForReport() {
        List<FlightTuppleTo> result = new ArrayList<>();
        List<Flight> allTowPlanes = flightRepository.findAllByFlightTypeOrderByTakeoffTimeAscIdAsc(Flight.Type.TOWPLANE);
        allTowPlanes.forEach((tF) ->
            result.add(FlightTuppleTo.builder()
                .towplane(FlightTo.fromEntity(tF.getTowplaneFlight()))
                .towplane(FlightTo.fromEntity(tF.getGliderFlight()))
                .build()));

        return result;
    }
}