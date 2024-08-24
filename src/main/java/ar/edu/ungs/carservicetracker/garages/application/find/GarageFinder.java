package ar.edu.ungs.carservicetracker.garages.application.find;

import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.garages.domain.GarageNotFound;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import org.springframework.stereotype.Component;

@Component
public class GarageFinder {
    private final GarageRepository repository;

    public GarageFinder(GarageRepository repository) {
        this.repository = repository;
    }

    public GarageResponse execute(Long id) {
        var garage =  this.repository.findById(id).orElseThrow(() -> new GarageNotFound(id));

        return GarageResponse.map(garage);
    }
}

