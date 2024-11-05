package eu.profinit.education.flightlog.airplane;

import eu.profinit.education.flightlog.common.JpaConstants;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Embeddable
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor(access = PACKAGE)
@AllArgsConstructor(access = PRIVATE)
public class Airplane {

    @ManyToOne
    @JoinColumn(name = JpaConstants.Columns.REGISTERED_AIRPLANE_ID)
    private ClubAirplane clubAirplane;

    private String guestAirplaneImmatriculation;
    private String guestAirplaneType;

    public static Airplane clubAirplane(ClubAirplane clubAirplane) {
        return Airplane.builder().clubAirplane(clubAirplane).build();
    }

    public static Airplane guestAirplane(String immatriculation, String type) {
        return Airplane.builder().guestAirplaneImmatriculation(immatriculation).guestAirplaneType(type).build();
    }

    public String getSafeImmatriculation(){
        if (clubAirplane == null) {
            return guestAirplaneImmatriculation;
        } else {
           return clubAirplane.getImmatriculation();
        }
    }

    public String getSafeType(){
        if (clubAirplane != null) {
            return clubAirplane.getType() != null ? clubAirplane.getType().getType() : null;
        } else {
            return guestAirplaneType;
        }
    }
}