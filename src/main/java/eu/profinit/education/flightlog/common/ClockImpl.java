package eu.profinit.education.flightlog.common;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ClockImpl implements Clock {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
