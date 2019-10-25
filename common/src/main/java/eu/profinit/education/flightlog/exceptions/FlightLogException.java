package eu.profinit.education.flightlog.exceptions;

import org.slf4j.helpers.MessageFormatter;

public class FlightLogException extends RuntimeException {

    /**
     * Constructs a new Flightlog exception with the specified detail message.
     * Message can be  with a list of parameters. Use {} as a placeholders for parameters in the message.
     *
     * It uses same implementation for formatting as {@link org.slf4j.Logger}.
     *
     * @param message    the detail message. The detail message is saved for
     *                   later retrieval by the {@link #getMessage()} method.
     * @param parameters a list of parameters (can be omitted)
     */
    public FlightLogException(String message, Object... parameters) {
        this(message, null, parameters);
    }

    /**
     * Constructs a new Flightlog exception with the specified detail message and a cause of this exception.
     * Message can be  with a list of parameters. Use {} as a placeholders for parameters in the message.
     *
     * It uses same implementation for formatting as {@link org.slf4j.Logger}.
     *
     * @param message    the detail message. The detail message is saved for
     *                   later retrieval by the {@link #getMessage()} method.
     * @param cause      the cause (which is saved for later retrieval by the
     *                   {@link #getCause()} method).  (A <tt>null</tt> value is
     *                   permitted, and indicates that the cause is nonexistent or
     *                   unknown.)
     * @param parameters a list of parameters (can be omitted)
     */
    public FlightLogException(String message, Throwable cause, Object... parameters) {
        super(formatMessage(message, parameters), cause);
    }

    private static String formatMessage(String message, Object... parameters) {
        return MessageFormatter.arrayFormat(message, parameters).getMessage();
    }
}
