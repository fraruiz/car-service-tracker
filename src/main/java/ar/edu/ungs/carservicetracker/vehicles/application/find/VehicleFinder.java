package ar.edu.ungs.carservicetracker.vehicles.application.find;

import ar.edu.ungs.carservicetracker.vehicles.application.VehicleResponse;
import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class VehicleFinder {
    private final VehicleRepository repository;

    public VehicleFinder(VehicleRepository repository) {
        this.repository = repository;
    }

    public VehicleResponse execute(String id) {
        var vehicle =  this.repository.findById(new VehicleId(id)).orElseThrow(VehicleNotFound::new);

        return VehicleResponse.map(vehicle);
    }



}
