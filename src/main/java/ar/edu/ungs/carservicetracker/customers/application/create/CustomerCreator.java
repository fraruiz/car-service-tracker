package ar.edu.ungs.carservicetracker.customers.application.create;

import ar.edu.ungs.carservicetracker.customers.application.CustomerRequest;
import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreator {
    private final CustomerRepository repository;

    public CustomerCreator(CustomerRepository repository) {
        this.repository = repository;
    }

    public void execute(CustomerRequest request) {
        Customer customer = new Customer(request.id(), request.fullname(), request.email());

        this.repository.save(customer);
    }
}
