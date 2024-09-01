package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.modify;

import ar.edu.ungs.carservicetracker.services.application.ConvertServiceInProgressRequest;
import ar.edu.ungs.carservicetracker.services.application.update.InProgressServiceConverter;
import ar.edu.ungs.carservicetracker.services.application.update.ServiceFinisher;
import ar.edu.ungs.carservicetracker.services.application.update.WaitingServiceConverter;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public final class PutUpdateServiceRestController {

    private static final String IN_PROGRESS = "IN_PROGRESS";
    private static final String WAITING = "WAITING";

    private final ServiceFinisher finisher;
    private final InProgressServiceConverter in_progress_converter;
    private final WaitingServiceConverter waiting_converter;

    public PutUpdateServiceRestController(ServiceFinisher finisher, InProgressServiceConverter converter, WaitingServiceConverter waitingConverter) {
        this.finisher = finisher;
        this.in_progress_converter = converter;
        this.waiting_converter = waitingConverter;
    }

    @PutMapping("/services/update")
    public ResponseEntity<?> handle(@RequestParam String status,
                                    @RequestBody ConvertServiceInProgressRequest in_request
                                  //  @RequestBody(required = false) ConvertServiceWaitingRequest w_request
                                    ) {
        try {

            //System.out.println(in_request.toString());
        //    System.out.println(w_request.toString());
            switch (status) {
                case IN_PROGRESS -> this.in_progress_converter.execute(in_request.id(), in_request);
              //  case WAITING -> this.waiting_converter.execute(w_request.id(), w_request);
            }

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (ServiceNotFound error) {
            return new ResponseEntity<>(Map.of("code", "not_found", "message", error.getMessage()), HttpStatus.NOT_FOUND);
        } catch (Exception error) {
            return new ResponseEntity<>(Map.of("code", "server_error", "message", error.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
