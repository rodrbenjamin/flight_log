package eu.profinit.education.flightlog.exceptions;

public class ValidationException extends FlightLogException {

    public ValidationException(String message, Object... parameters) {
        super(message, parameters);
    }

    public ValidationException(String message, Throwable cause, Object... parameters) {
        super(message, cause, parameters);
    }
}
