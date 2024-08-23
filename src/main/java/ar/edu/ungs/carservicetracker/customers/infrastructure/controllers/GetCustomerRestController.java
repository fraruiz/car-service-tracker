package ar.edu.ungs.carservicetracker.customers.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.customers.application.find.CustomerFinder;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetCustomerRestController {
    private final CustomerFinder finder;

    public GetCustomerRestController(CustomerFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/api/customers/{id}")
    public ResponseEntity<?> handle(@PathVariable Long id) {
        try {
            var customer = this.finder.execute(id);

            return ResponseEntity.ok(customer);
        } catch (CustomerNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}
