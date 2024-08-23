package ar.edu.ungs.carservicetracker.customers.domain;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository {
    void save(Customer customer);

    Optional<Customer> findById(Long id);

    List<Customer> searchAll();
}
