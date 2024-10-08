package ar.edu.ungs.carservicetracker.garages.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.garages.application.find.GarageFinder;
import ar.edu.ungs.carservicetracker.garages.domain.GarageNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GetGarageRestController {
    private final GarageFinder finder;

    public GetGarageRestController(GarageFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/api/garages/{id}")
    public ResponseEntity<?> handle(@PathVariable String id) {
        try {
            var garage = this.finder.execute(id);

            return ResponseEntity.ok(garage);
        } catch (GarageNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}
