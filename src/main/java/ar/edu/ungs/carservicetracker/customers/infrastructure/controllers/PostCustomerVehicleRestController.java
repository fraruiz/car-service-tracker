package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;


import ar.edu.ungs.carservicetracker.customers.application.AssignVehicleRequest;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.customers.application.assign.CustomerVehicleAssigner;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostCustomerVehicleRestController {
    private final CustomerVehicleAssigner assigner;

    public PostCustomerVehicleRestController(CustomerVehicleAssigner assigner) {
        this.assigner = assigner;
    }

    @PostMapping("/customers/assignVehicle")
    public ResponseEntity<?> handle(@RequestBody AssignVehicleRequest request) {
        try {

           this.assigner.execute(request);

            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (CustomerNotFound e) {
        return ResponseEntity.notFound().build();
        }
    }
}
