package ar.edu.ungs.carservicetracker.customers.infrastructure.pesistence;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryCustomerRepository implements CustomerRepository {
    private final Map<Long, Customer> values;

    public InMemoryCustomerRepository() {
        this.values = new HashMap<>();
    }

    @Override
    public void save(Customer customer) {
        this.values.put(customer.id(), customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        if (this.values.containsKey(id)) {
            return Optional.of(this.values.get(id));
        }

        return Optional.empty();
    }

    @Override
    public List<Customer> searchAll() {
        return this.values.values().stream().toList();
    }
}
