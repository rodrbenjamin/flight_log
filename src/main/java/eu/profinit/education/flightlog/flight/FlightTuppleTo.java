package eu.profinit.education.flightlog.flight;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value
@Builder
@Jacksonized
public class FlightTuppleTo {
    FlightTo towplane;

    FlightTo glider;
}