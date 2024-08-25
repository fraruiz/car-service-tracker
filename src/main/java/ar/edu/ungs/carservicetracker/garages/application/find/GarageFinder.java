package ar.edu.ungs.carservicetracker.garages.application.find;

import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.garages.domain.GarageId;
import ar.edu.ungs.carservicetracker.garages.domain.GarageNotFound;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import org.springframework.stereotype.Component;

@Component
public class GarageFinder {
    private final GarageRepository repository;

    public GarageFinder(GarageRepository repository) {
        this.repository = repository;
    }

    public GarageResponse execute(String id) {
        var garage =  this.repository.findById(new GarageId(id))
                                     .orElseThrow(GarageNotFound::new);

        return GarageResponse.map(garage);
    }
}

