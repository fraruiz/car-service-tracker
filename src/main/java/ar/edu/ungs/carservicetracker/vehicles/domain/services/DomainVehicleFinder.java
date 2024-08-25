package ar.edu.ungs.carservicetracker.vehicles.domain.services;

import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class DomainVehicleFinder {
    private final VehicleRepository repository;

    public DomainVehicleFinder(VehicleRepository repository) {
        this.repository = repository;
    }

    public Vehicle execute(VehicleId id) {
        return this.repository.findById(id).orElseThrow(VehicleNotFound::new);
    }
}
