package ar.edu.ungs.carservicetracker.vehicles.infrastructure.controllers;


import ar.edu.ungs.carservicetracker.vehicles.application.VehicleResponse;
import ar.edu.ungs.carservicetracker.vehicles.application.search.VehicleSearcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetVehiclesRestController {
    private final VehicleSearcher searcher;

    public GetVehiclesRestController(VehicleSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/vehicles")
    public ResponseEntity<List<VehicleResponse>> handle() {
        var vehicles = this.searcher.execute();

        return ResponseEntity.ok(vehicles);
    }
}
