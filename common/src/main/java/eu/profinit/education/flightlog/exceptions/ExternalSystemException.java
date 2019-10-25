package eu.profinit.education.flightlog.exceptions;

public class ExternalSystemException extends FlightLogException {

    public ExternalSystemException(String message, Object... parameters) {
        super(message, parameters);
    }

    public ExternalSystemException(String message, Throwable cause, Object... parameters) {
        super(message, cause, parameters);
    }
}
