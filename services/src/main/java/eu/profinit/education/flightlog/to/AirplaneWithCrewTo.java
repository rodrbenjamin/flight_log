package eu.profinit.education.flightlog.to;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class AirplaneWithCrewTo implements Serializable {

    private AirplaneTo airplane;
    private PersonTo pilot;
    private PersonTo copilot;
    private String note;
}
