package eu.profinit.education.flightlog.airplane;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import static eu.profinit.education.flightlog.common.JpaConstants.Tables.AIRPLANE_TYPE;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@Setter
@ToString
@Table(name = AIRPLANE_TYPE)
@NoArgsConstructor(access = PACKAGE)
public class AirplaneType {

    @Id
    private Long id;
    @Column(unique = true)
    private String type;
    private int maxCapacity = 1;

}