package ar.edu.ungs.carservicetracker.services.infrastructure.controllers;

import ar.edu.ungs.carservicetracker.services.application.ServiceResponse;
import ar.edu.ungs.carservicetracker.services.application.search.ServiceSearcher;
import ar.edu.ungs.carservicetracker.services.domain.ServiceCriteria;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import ar.edu.ungs.carservicetracker.shared.domain.Pagination;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class GetServicesRestController {
    private final ServiceSearcher searcher;

    public GetServicesRestController(ServiceSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/services")
    public  ResponseEntity<?> handle() {
           try { // ServiceCriteria criteria = new ServiceCriteria(size, page, userId);
               //Pagination<ServiceResponse> pagination = this.searcher.execute(criteria);
               var values = searcher.execute();

               return ResponseEntity.ok(values);
           }catch (Exception error) {
               return ResponseEntity.internalServerError().build();
           }
    }
}
