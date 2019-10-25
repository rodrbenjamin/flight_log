package eu.profinit.education.flightlog.to;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
public class FlightTakeoffTo implements Serializable {

    private LocalDateTime takeoffTime;
    private String task;
    private AirplaneWithCrewTo towplane;
    private AirplaneWithCrewTo glider;

}

