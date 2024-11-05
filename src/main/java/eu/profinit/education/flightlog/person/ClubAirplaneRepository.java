package eu.profinit.education.flightlog.person;

import eu.profinit.education.flightlog.airplane.ClubAirplane;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubAirplaneRepository extends JpaRepository<ClubAirplane, Long> {

    Optional<ClubAirplane> findById(Long id);
}