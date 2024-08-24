package ar.edu.ungs.carservicetracker.vehicles.infrastructure.pesistence;


import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryVehicleRepository implements VehicleRepository {
    private final Map<Long, Vehicle> values;

    public InMemoryVehicleRepository() {
        this.values = new HashMap<>();
    }


    @Override
    public void save(Vehicle vehicle) {

        Long vehicleId = Long.parseLong(vehicle.id().value());

        this.values.put(vehicleId, vehicle); //Me tira error porque pide un long


    }

    @Override
    public Optional<Vehicle> findById(Long id) {

        if (this.values.containsKey(id)) {
            return Optional.of(this.values.get(id));
        }

        return Optional.empty();
    }


    @Override
    public Optional<Vehicle> findByLicensePlate(String licensePlate) {
        return values.values()
                .stream()
                .filter(vehicle -> vehicle.licensePlate().value().equals(licensePlate))
                .findFirst();
    }

    @Override
    public List<Vehicle> searchAll() {
        return this.values.values().stream().toList();
    }
}
