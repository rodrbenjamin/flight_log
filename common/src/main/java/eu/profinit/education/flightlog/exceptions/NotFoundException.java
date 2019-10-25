package eu.profinit.education.flightlog.exceptions;

public class NotFoundException extends FlightLogException {

    public NotFoundException(String message, Object... parameters) {
        super(message, parameters);
    }

    public NotFoundException(String message, Throwable cause, Object... parameters) {
        super(message, cause, parameters);
    }
}
