package eu.profinit.education.flightlog.to;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized
public class FlightLandingTo {

    Long flightId;

    LocalDateTime landingTime;
}