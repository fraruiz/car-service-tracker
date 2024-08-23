package ar.edu.ungs.carservicetracker.customers.application.search;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomersSearcher {
    private final CustomerRepository repository;

    public CustomersSearcher(CustomerRepository repository) {
        this.repository = repository;
    }

    public List<CustomerResponse> execute() {
        return this.repository.searchAll()
                              .stream()
                              .map(CustomerResponse::map)
                              .toList();
    }
}
