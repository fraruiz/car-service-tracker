package ar.edu.ungs.carservicetracker.vehicles.domain;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    void save(Vehicle vehicle);

    Optional<Vehicle> findById(VehicleId id);

    List<Vehicle> searchAll();
}
