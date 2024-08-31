package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.users.application.UserResponse;
import ar.edu.ungs.carservicetracker.users.application.find.UserFinder;
import ar.edu.ungs.carservicetracker.users.application.search.UserSearcher;
import ar.edu.ungs.carservicetracker.users.domain.UserFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GetUsersRestController {
    private final UserSearcher searcher;

    public GetUsersRestController(UserSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> handle() {
        try {
            var values = this.searcher.execute();

            return ResponseEntity.ok(values);
        } catch (Exception error) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
