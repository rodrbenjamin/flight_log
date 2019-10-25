package eu.profinit.education.flightlog.domain.repositories;

import eu.profinit.education.flightlog.domain.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    // TODO 2.1: Upravte metodu findAll tak, aby podle jejího názvu SpringData správně načtla všechny lety kluzáků (Fligh.Type.GLIDER)
    List<Flight> findAll();

    // TODO 2.3: Vytvořte metodu podle jejíhož názvu SpringData správně načte lety, které jsou právě ve vzduchu
    // Lety by se měly řadit od nejstarších a v případě shody podle ID tak, aby vlečná byla před kluzákem, který táhne
    // Výsledek si můžete ověřit v testu k této tříde v modulu services



    // TODO 8.1: Vytvorte metodu pro nacteni vlecnych letu pro vytvoreni dvojice letu na obrazovce Report

}

