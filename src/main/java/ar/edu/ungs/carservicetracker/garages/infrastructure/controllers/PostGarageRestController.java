package ar.edu.ungs.carservicetracker.garages.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.garages.application.GarageRequest;
import ar.edu.ungs.carservicetracker.garages.application.create.GarageCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostGarageRestController {
    private final GarageCreator creator;

    public PostGarageRestController(GarageCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/api/garages")
    public ResponseEntity<?> handle(@RequestBody GarageRequest request) {
        this.creator.execute(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
