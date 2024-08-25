package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.customers.application.CustomerRequest;
import ar.edu.ungs.carservicetracker.customers.application.create.CustomerCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostCustomerRestController {
    private final CustomerCreator creator;

    public PostCustomerRestController(CustomerCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/api/customers")
    public ResponseEntity<?> handle(@RequestBody CustomerRequest request) {
        this.creator.execute(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
