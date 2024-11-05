package eu.profinit.education.flightlog.person;

import eu.profinit.education.flightlog.common.JpaConstants;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.ObjectUtils;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = JpaConstants.Tables.PERSON)
@SequenceGenerator(name = JpaConstants.Sequences.PERSON, sequenceName = JpaConstants.Sequences.PERSON, initialValue = JpaConstants.Sequences.INITIAL_VALUE)
@Getter
@Setter
@ToString
@NoArgsConstructor(access = AccessLevel.PACKAGE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Person {

    @Id
    @GeneratedValue(generator = JpaConstants.Sequences.PERSON)
    private Long id;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Type personType;

    protected String firstName;
    protected String lastName;
    private Address address;
    private Long memberId;

    public Person(Type personType, String firstName, String lastName, Address address) {
        this.personType = personType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Person(@NotNull Type personType, Long memberId, String firstName, String lastName) {
        this.personType = personType;
        this.memberId = memberId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public enum Type {
        CLUB_MEMBER,
        GUEST
    }

    public String getFullName() {
        return (ObjectUtils.defaultIfNull(firstName, "") + " " + ObjectUtils.defaultIfNull(lastName, "")).trim();
    }
}