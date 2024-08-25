package ar.edu.ungs.carservicetracker.vehicles.infrastructure.pesistence;


import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryVehicleRepository implements VehicleRepository {
    private final Map<String, Vehicle> values;

    public InMemoryVehicleRepository() {
        this.values = new HashMap<>();
    }


    @Override
    public void save(Vehicle vehicle) {
        this.values.put(vehicle.id().value(), vehicle);
    }

    @Override
    public Optional<Vehicle> findById(VehicleId id) {
        if (this.values.containsKey(id.value())) {
            return Optional.of(this.values.get(id.value()));
        }

        return Optional.empty();
    }

    @Override
    public List<Vehicle> searchAll() {
        return this.values.values().stream().toList();
    }
}
