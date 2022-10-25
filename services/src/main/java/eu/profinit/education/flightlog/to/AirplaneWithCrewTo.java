package eu.profinit.education.flightlog.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Value
@Builder
@AllArgsConstructor
@Jacksonized
public class AirplaneWithCrewTo implements Serializable {

    AirplaneTo airplane;

    PersonTo pilot;

    PersonTo copilot;

    String note;
}