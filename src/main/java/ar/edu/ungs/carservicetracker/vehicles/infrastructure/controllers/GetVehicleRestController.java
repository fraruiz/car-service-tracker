package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.vehicles.application.find.VehicleFinder;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GetVehicleRestController {
    private final VehicleFinder finder;

    public GetVehicleRestController(VehicleFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/api/vehicles/{id}")
    public ResponseEntity<?> handle(@PathVariable String id) {
        try {
            var vehicle = this.finder.execute(id);

            return ResponseEntity.ok(vehicle);
        } catch (VehicleNotFound e) {
            return ResponseEntity.notFound().build();
        }
    }
}
