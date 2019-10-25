package eu.profinit.education.flightlog.to;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class FlightLandingTo {

    private Long flightId;
    private LocalDateTime landingTime;

}
