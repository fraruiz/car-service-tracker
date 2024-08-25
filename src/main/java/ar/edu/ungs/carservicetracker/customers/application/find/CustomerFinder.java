package ar.edu.ungs.carservicetracker.customers.application.find;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerFinder {
    private final CustomerRepository repository;

    public CustomerFinder(CustomerRepository repository) {
        this.repository = repository;
    }

    public CustomerResponse execute(String id) {
        var customer =  this.repository.findById(new CustomerId(id)).orElseThrow(CustomerNotFound::new);

        return CustomerResponse.map(customer);
    }
}
