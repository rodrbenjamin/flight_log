package eu.profinit.education.flightlog.domain.repositories;

import eu.profinit.education.flightlog.domain.codebooks.ClubAirplane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubAirplaneRepository extends JpaRepository<ClubAirplane, Long> {

    Optional<ClubAirplane> findById(Long id);
}
