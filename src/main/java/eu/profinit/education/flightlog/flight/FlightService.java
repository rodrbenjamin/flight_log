package eu.profinit.education.flightlog.flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    void takeoff(FlightTakeoffTo flightStart);

    /**
     * Sets landing time to flight.
     *
     * @param flightId    flight ID
     * @param landingTime landing time, if it is <code>null</code> current time is used
     */
    void land(FlightId flightId, LocalDateTime landingTime);

    List<FlightTo> getFlightsInTheAir();

    List<FlightTuppleTo> getFlightsForReport();
}