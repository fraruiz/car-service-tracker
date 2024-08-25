package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.find.ServiceFinder;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GetServiceRestController {
    private final ServiceFinder finder;

    public GetServiceRestController(ServiceFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/api/services/{id}")
    public ResponseEntity<?> handle(@PathVariable String id) {
        try {
            var service = this.finder.execute(id);

            return ResponseEntity.ok(service);
        } catch (ServiceNotFound error) {
            return new ResponseEntity<>(Map.of("code", "not_found", "message", error.getMessage()), HttpStatus.NOT_FOUND);
        }
    }
}
