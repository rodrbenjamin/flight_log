package eu.profinit.education.flightlog.airplane;

import eu.profinit.education.flightlog.common.JpaConstants;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import static eu.profinit.education.flightlog.common.JpaConstants.Tables.CLUB_AIRPLANE;
import static lombok.AccessLevel.PACKAGE;

@Entity
@Getter
@Setter
@ToString
@Table(name = CLUB_AIRPLANE)
@NoArgsConstructor(access = PACKAGE)
public class ClubAirplane {

    @Id
    private Long id;

    @Column(unique = true)
    private String immatriculation;

    @ManyToOne
    @JoinColumn(name = JpaConstants.Columns.TYPE_ID)
    private AirplaneType type;

    private boolean archived;


}