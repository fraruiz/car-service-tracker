package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.garages.domain.GarageNotFound;
import ar.edu.ungs.carservicetracker.users.application.UserRequest;
import ar.edu.ungs.carservicetracker.users.application.register.UserRegistrar;
import ar.edu.ungs.carservicetracker.users.domain.UserFound;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;
import java.util.Map;

@RestController
public final class PostUserRestController {
    private final UserRegistrar registrar;

    public PostUserRestController(UserRegistrar registrar) {
        this.registrar = registrar;
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> handle(@RequestBody UserRequest request) {
        try {
            this.registrar.execute(request);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UserFound | InvalidParameterException error) {
            return ResponseEntity.badRequest().body(Map.of("code", "bad_request", "message", error.getMessage()));
        } catch (GarageNotFound ignored) {
            return ResponseEntity.notFound().build();
        } catch (Exception error) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
