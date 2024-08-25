package ar.edu.ungs.carservicetracker.vehicles.application.search;

import ar.edu.ungs.carservicetracker.vehicles.application.VehicleResponse;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VehicleSearcher {
    private final VehicleRepository repository;

    public VehicleSearcher(VehicleRepository repository) {
        this.repository = repository;
    }

    public List<VehicleResponse> execute() {
        return this.repository.searchAll()
                              .stream()
                              .map(VehicleResponse::map)
                              .toList();
    }
}
