package ar.edu.ungs.carservicetracker.services.infrastructure.controllers.create;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.customers.application.search.CustomersSearcher;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetServicesCreateRestController {
    private final CustomersSearcher searcher;

    public GetServicesCreateRestController(CustomersSearcher searcher) {
        this.searcher = searcher;
    }

    @GetMapping("/api/Services/create")
    public ResponseEntity<List<CustomerResponse>> handle() {
        var customers = this.searcher.execute();

        return ResponseEntity.ok(customers);
    }
}
