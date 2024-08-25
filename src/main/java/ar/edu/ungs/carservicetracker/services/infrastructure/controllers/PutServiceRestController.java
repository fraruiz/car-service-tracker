package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.ConvertServiceInProgressRequest;
import ar.edu.ungs.carservicetracker.services.application.update.InProgressServiceConverter;
import ar.edu.ungs.carservicetracker.services.application.update.ServiceFinisher;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public final class PutServiceRestController {
    private static final String FINISH = "finish";
    private static final String IN_PROGRESS = "in_progress";

    private final ServiceFinisher finisher;
    private final InProgressServiceConverter converter;

    public PutServiceRestController(ServiceFinisher finisher, InProgressServiceConverter converter) {
        this.finisher = finisher;
        this.converter = converter;
    }

    @PutMapping("/api/services/{id}/status")
    public ResponseEntity<?> handle(@PathVariable String id,
                                    @RequestParam String status,
                                    @RequestBody(required = false) ConvertServiceInProgressRequest request) {
        try {
            switch (status) {
                case FINISH -> this.finisher.execute(id);
                case IN_PROGRESS -> this.converter.execute(id, request);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceNotFound error) {
            return new ResponseEntity<>(Map.of("code", "not_found", "message", error.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(Map.of("code", "server_error", "message", error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
