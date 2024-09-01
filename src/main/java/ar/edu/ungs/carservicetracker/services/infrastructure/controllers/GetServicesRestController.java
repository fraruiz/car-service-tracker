package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.search.ServiceSearcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public final class GetServicesRestController {
    private final ServiceSearcher searcher;

    public GetServicesRestController(ServiceSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/services")
    public  ResponseEntity<?> handle() {
           try {
               var values = searcher.execute();

               return ResponseEntity.ok(values);
           }catch (Exception error) {
               return ResponseEntity.internalServerError().build();
           }
    }
}
