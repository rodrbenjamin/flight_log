package eu.profinit.education.flightlog.common;

import java.time.LocalDateTime;

/**
 * Provides time in the whole applications.
 */
public interface Clock {

    LocalDateTime now();
}
