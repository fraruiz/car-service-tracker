package ar.edu.ungs.carservicetracker.users.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.users.application.AuthUserRequest;
import ar.edu.ungs.carservicetracker.users.application.auth.UserAuthenticator;
import ar.edu.ungs.carservicetracker.users.domain.UnauthorizedUser;
import ar.edu.ungs.carservicetracker.users.domain.UserFound;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class PostUserAuthRestController {
    private final UserAuthenticator authenticator;

    public PostUserAuthRestController(UserAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @PostMapping("/api/users/authentications")
    public ResponseEntity<?> handle(@RequestBody AuthUserRequest request, HttpSession session) {
        try {
             var userId = this.authenticator.execute(request);

            session.setAttribute("user_id", userId);

             return ResponseEntity.ok(Map.of("status", "user authenticated"));
        } catch (UnauthorizedUser error) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        } catch (Exception error) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
