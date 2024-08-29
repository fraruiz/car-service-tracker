package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;



import ar.edu.ungs.carservicetracker.customers.application.find.CustomerFinder;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;

import ar.edu.ungs.carservicetracker.vehicles.application.find.VehicleFinder;
import ar.edu.ungs.carservicetracker.vehicles.application.search.VehicleSearcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
public class GetCustomerVehiclesRestController {
    private final VehicleFinder vehicleFinder;
    private final CustomerFinder finder;

    public GetCustomerVehiclesRestController(CustomerFinder finder, VehicleFinder vehicleFinder) {
        this.finder = finder;
        this.vehicleFinder = vehicleFinder;
    }


    @GetMapping("/api/customers/{id}/vehicles")
    public ResponseEntity<?> handle(@PathVariable String id) {

    try {
        var customer = this.finder.execute(id).values();
        var vehicles = this.vehicleFinder.execute(customer.stream()
                                                          .map(Object::toString)
                                                          .collect(Collectors.joining(",")));
            return ResponseEntity.ok(vehicles);

    } catch (CustomerNotFound e) {
        return ResponseEntity.notFound().build();
    }
}

}
