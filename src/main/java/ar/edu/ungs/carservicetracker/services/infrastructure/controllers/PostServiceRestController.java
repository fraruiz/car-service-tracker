package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.services.application.ServiceRequest;
import ar.edu.ungs.carservicetracker.services.application.create.ServiceCreator;
import ar.edu.ungs.carservicetracker.users.domain.UserNotFound;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class PostServiceRestController {
    private final ServiceCreator creator;

    public PostServiceRestController(ServiceCreator creator) {
        this.creator = creator;
    }

    @PostMapping("/services/create")
    public ResponseEntity<?> handle(@RequestBody ServiceRequest request) {
        try {
            System.out.println(request.toString());
            this.creator.execute(request);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserNotFound | CustomerNotFound | VehicleNotFound error) {
            return new ResponseEntity<>(Map.of("code", "not_found", "message", error.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(Map.of("code", "server_error", "message", error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
