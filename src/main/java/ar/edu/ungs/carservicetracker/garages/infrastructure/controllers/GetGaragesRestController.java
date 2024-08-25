package ar.edu.ungs.carservicetracker.garages.infrastructure.controllers;


import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.garages.application.search.GaragesSearcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetGaragesRestController {
    private final GaragesSearcher searcher;

    public GetGaragesRestController(GaragesSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/garages")
    public ResponseEntity<List<GarageResponse>> handle() {
        var Garages = this.searcher.execute();

        return ResponseEntity.ok(Garages);
    }
}
