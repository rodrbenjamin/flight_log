package eu.profinit.education.flightlog.to;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized
public class FlightTakeoffTo implements Serializable {

    LocalDateTime takeoffTime;

    String task;

    AirplaneWithCrewTo towplane;

    AirplaneWithCrewTo glider;

}