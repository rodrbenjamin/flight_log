package eu.profinit.education.flightlog.domain;

public interface JpaConstants {

    interface Tables {
        String CLUB_AIRPLANE = "c_club_airplane";
        String AIRPLANE_TYPE = "c_airplane_type";
        String FLIGHT = "t_flight";
        String PERSON = "t_person";
    }

    interface Sequences {
        String FLIGHT = "seq_flight";
        String PERSON = "seq_person";
        int INITIAL_VALUE = 100;
    }

    interface Columns {
        String TASK = "task";
        String TOWPLANE_FLIGHT_ID = "towplane_flight_id";
        String GLIDER_FLIGHT_ID = "glider_flight_id";
        String TYPE_ID = "type_id";
        String REGISTERED_AIRPLANE_ID = "club_airplane_id";
        String PILOT_PERSON_ID = "pilot_person_id";
        String COPILOT_PERSON_ID = "copilot_person_id";
    }
}
