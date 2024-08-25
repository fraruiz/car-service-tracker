package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.customers.application.CustomerRequest;
import ar.edu.ungs.carservicetracker.customers.application.create.CustomerCreator;
import ar.edu.ungs.carservicetracker.vehicles.application.VehicleRequest;
import ar.edu.ungs.carservicetracker.vehicles.application.create.VehicleCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostVehicleRestController {
    private final VehicleCreator creator;

    public PostVehicleRestController(VehicleCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/api/vehicles")
    public ResponseEntity<?> handle(@RequestBody VehicleRequest request) {
        this.creator.execute(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
