package eu.profinit.education.flightlog.to;

import eu.profinit.education.flightlog.domain.entities.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.io.Serializable;

@Value
@AllArgsConstructor
@Builder
@Jacksonized
public class PersonTo implements Serializable {

    Long memberId;

    String firstName;

    String lastName;

    AddressTo address;

    public static PersonTo ofGuest(String firstName, String lastName, AddressTo address) {
        return new PersonTo(null, firstName, lastName, address);
    }

    public static PersonTo ofClubMember(Long memberId) {
        return ofClubMember(memberId, null, null);
    }

    public static PersonTo ofClubMember(Long memberId, String firstName, String lastName) {
        return new PersonTo(memberId, firstName, lastName, null);
    }

    public static PersonTo fromEntity(Person entity) {
        if (entity == null) {
            return null;
        }
        return new PersonTo(entity.getMemberId(), entity.getFirstName(), entity.getLastName(), AddressTo.fromEntity(entity.getAddress()));
    }
}