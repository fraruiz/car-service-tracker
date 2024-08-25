package ar.edu.ungs.carservicetracker.customers.domain.services;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class DomainCustomerFinder {
    private final CustomerRepository repository;

    public DomainCustomerFinder(CustomerRepository repository) {
        this.repository = repository;
    }

    public Customer execute(CustomerId id) {
        return this.repository.findById(id).orElseThrow(CustomerNotFound::new);
    }
}
