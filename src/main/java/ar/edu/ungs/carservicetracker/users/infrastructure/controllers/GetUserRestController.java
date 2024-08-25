package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.users.application.UserResponse;
import ar.edu.ungs.carservicetracker.users.application.find.UserFinder;
import ar.edu.ungs.carservicetracker.users.domain.UserFound;
import ar.edu.ungs.carservicetracker.users.domain.UserNotFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GetUserRestController {
    private final UserFinder finder;

    public GetUserRestController(UserFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/api/users/{id}")
    public ResponseEntity<?> handle(@PathVariable String id) {
        try {
            UserResponse user = this.finder.execute(id);

            return ResponseEntity.ok(user);
        } catch (UserFound error) {
            return ResponseEntity.badRequest().body(Map.of("code", error.code(), "message", error.getMessage()));
        } catch (Exception error) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
