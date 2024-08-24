package ar.edu.ungs.carservicetracker.garages.application.search;

import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GaragesSearcher {
    private final GarageRepository repository;

    public GaragesSearcher(GarageRepository repository) {
        this.repository = repository;
    }

    public List<GarageResponse> execute() {
        return this.repository.searchAll()
                              .stream()
                              .map(GarageResponse::map)
                              .toList();
    }
}
