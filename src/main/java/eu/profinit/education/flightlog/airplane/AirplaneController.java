package eu.profinit.education.flightlog.airplane;

import java.util.List;

import eu.profinit.education.flightlog.flight.FlightTuppleTo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AirplaneController {

    private final AirplaneService airplaneService;

    @GetMapping("airplane")
    public List<AirplaneTo> getClubAirplanes(){
        log.debug("Called REST ENDPOINT getClubAirplanes");
        return airplaneService.getClubAirplanes();
    }
}