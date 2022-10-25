package eu.profinit.education.flightlog.to;

import eu.profinit.education.flightlog.domain.entities.Address;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Value
@Builder
@Jacksonized
public class AddressTo implements Serializable {

    String street;

    String city;

    String postalCode;

    String country;

    public static AddressTo fromEntity(Address entity) {
        if (entity == null) {
            return null;
        }
        return new AddressTo(entity.getStreet(), entity.getCity(), entity.getPostalCode(), entity.getCountry());
    }
}