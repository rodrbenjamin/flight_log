package eu.profinit.education.flightlog.person;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Embeddable;

import static lombok.AccessLevel.PACKAGE;

@Embeddable
@Getter
@Setter
@ToString
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor
public class Address {

    private String street;
    private String city;
    private String postalCode;
    private String country;
}