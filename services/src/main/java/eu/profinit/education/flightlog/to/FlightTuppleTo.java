package eu.profinit.education.flightlog.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class FlightTuppleTo {
    private FlightTo towplane;
    private FlightTo glider;
}
