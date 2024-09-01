package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.finish;

import ar.edu.ungs.carservicetracker.services.application.ConvertServiceInProgressRequest;
import ar.edu.ungs.carservicetracker.services.application.FinishServiceRequest;
import ar.edu.ungs.carservicetracker.services.application.update.InProgressServiceConverter;
import ar.edu.ungs.carservicetracker.services.application.update.ServiceFinisher;
import ar.edu.ungs.carservicetracker.services.application.update.WaitingServiceConverter;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

@RestController
public final class PutFinishServiceRestController {
    private static final String FINISH = "FINISH";


    private final ServiceFinisher finisher;


    public PutFinishServiceRestController(ServiceFinisher finisher ) {
        this.finisher = finisher;

    }

    @PutMapping("/services/finish")
    public ResponseEntity<?> handle(@RequestParam String status,
                                    @RequestBody FinishServiceRequest request) {
        try {
            System.out.println(request.toString());
            if(Objects.equals(status, FINISH)) {
                this.finisher.execute(request.id());
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceNotFound error) {
            return new ResponseEntity<>(Map.of("code", "not_found", "message", error.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(Map.of("code", "server_error", "message", error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
