package eu.profinit.education.flightlog.domain.entities;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Value;
import org.springframework.util.Assert;

import java.io.Serializable;

@Value
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@EqualsAndHashCode
public class FlightId implements Serializable {

    Long id;

    public static FlightId of(Long id) {
        Assert.notNull(id, "Flight ID cannot be null");
        return new FlightId(id);
    }
}