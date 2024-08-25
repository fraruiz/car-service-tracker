package ar.edu.ungs.carservicetracker.garages.domain;

import org.springframework.stereotype.Component;

@Component
public class DomainGarageFinder {
    private final GarageRepository repository;

    public DomainGarageFinder(GarageRepository repository) {
        this.repository = repository;
    }

    public Garage execute(String id) {
        return this.repository.findById(new GarageId(id)).orElseThrow(GarageNotFound::new);
    }
}

