package ar.edu.ungs.carservicetracker.garages.application.create;

import ar.edu.ungs.carservicetracker.garages.application.GarageRequest;

import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import org.springframework.stereotype.Component;

@Component
public class GarageCreator {
    private final GarageRepository repository;

    public GarageCreator(GarageRepository repository) {
        this.repository = repository;
    }

    public void execute(GarageRequest request) {
        Garage garage = Garage.create(request.id(), request.garageName());

        this.repository.save(garage);
    }
}
