package ar.edu.ungs.carservicetracker.vehicles.domain;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository {
    void save(Vehicle vehicle);

    Optional<Vehicle> findById(Long id);
    Optional<Vehicle> findByLicensePlate(String licensePlate);

    List<Vehicle> searchAll();
}
