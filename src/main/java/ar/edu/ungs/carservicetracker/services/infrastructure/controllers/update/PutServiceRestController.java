package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.update;

import ar.edu.ungs.carservicetracker.services.application.UpdateServiceRequest;
import ar.edu.ungs.carservicetracker.services.application.update.ServiceUpdater;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public final class PutServiceRestController {
    private final ServiceUpdater updater;

    public PutServiceRestController(ServiceUpdater updater) {
        this.updater = updater;
    }

    @PutMapping("/api/services/{id}")
    public ResponseEntity<?> handle(@PathVariable String id,
                                    @RequestBody UpdateServiceRequest request) {
        try {
            this.updater.execute(UpdateServiceRequest.build(id, request));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(Map.of("message", e.getMessage()));
        }
    }
}
