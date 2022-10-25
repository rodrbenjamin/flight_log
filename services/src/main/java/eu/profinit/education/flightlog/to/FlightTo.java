package eu.profinit.education.flightlog.to;

import eu.profinit.education.flightlog.domain.entities.Flight;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;
import java.time.LocalDateTime;

@Value
@Builder
@Jacksonized
public class FlightTo implements Serializable {

    Long id;

    LocalDateTime takeoffTime;

    LocalDateTime landingTime;

    AirplaneTo airplane;

    PersonTo pilot;

    PersonTo copilot;

    String task;

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