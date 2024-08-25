package ar.edu.ungs.carservicetracker.vehicles.application.create;

import ar.edu.ungs.carservicetracker.vehicles.application.VehicleRequest;
import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class VehicleCreator {
    private final VehicleRepository repository;

    public VehicleCreator(VehicleRepository repository) {
        this.repository = repository;
    }

    public void execute(VehicleRequest request) {
        Vehicle vehicle = Vehicle.create(request.id(), request.licensePlate(), request.brand(),request.model(), request.mileage());

        this.repository.save(vehicle);
    }
}
