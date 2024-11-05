package eu.profinit.education.flightlog.airplane;

import eu.profinit.education.flightlog.person.PersonTo;
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