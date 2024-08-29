package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;


import ar.edu.ungs.carservicetracker.customers.application.CustomerRequest;

import ar.edu.ungs.carservicetracker.customers.application.find.CustomerFinder;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.vehicles.application.VehicleAssigner;
import ar.edu.ungs.carservicetracker.vehicles.application.VehicleRequest;
import ar.edu.ungs.carservicetracker.vehicles.application.create.VehicleCreator;
import ar.edu.ungs.carservicetracker.vehicles.application.find.VehicleFinder;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleAlreadyExists;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostCustomerAddVehicleRestController {

    private final VehicleAssigner assigner;
    private final CustomerFinder finder;
    private final VehicleCreator creator;

    public PostCustomerAddVehicleRestController(VehicleAssigner assigner, CustomerFinder finder, VehicleCreator creator) {

        this.assigner = assigner;
        this.finder = finder;
        this.creator = creator;

    }


    @PostMapping("/api/customers/{id}/vehicles/add")
    public ResponseEntity<?> handle(@RequestBody VehicleRequest request, @PathVariable String id) {
        try {
            var customer = this.finder.execute(id);

            try{
                this.creator.execute(request);

                this.assigner.assign(request.id(),customer.id());
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            }
            catch (VehicleAlreadyExists e) {
                return ResponseEntity.badRequest().build();
            }
        } catch (CustomerNotFound e) {
            return ResponseEntity.notFound().build();
            }
    }

}
