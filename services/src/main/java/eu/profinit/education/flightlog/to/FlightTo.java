package eu.profinit.education.flightlog.to;

import eu.profinit.education.flightlog.domain.entities.Flight;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightTo implements Serializable {

    private Long id;
    private LocalDateTime takeoffTime;
    private LocalDateTime landingTime;
    private AirplaneTo airplane;

    private PersonTo pilot;
    private PersonTo copilot;

    private String task;

    public static FlightTo fromEntity(Flight entity) {
        if (entity == null) {
            return null;
        }
        return new FlightTo(
            entity.getId().getId(),
            entity.getTakeoffTime(),
            entity.getLandingTime(),
            AirplaneTo.fromEntity(entity.getAirplane()),
            PersonTo.fromEntity(entity.getPilot()),
            PersonTo.fromEntity(entity.getCopilot()),
            entity.getTask().getValue()
        );
    }
}
