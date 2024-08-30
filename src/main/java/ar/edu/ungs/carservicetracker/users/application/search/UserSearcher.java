package ar.edu.ungs.carservicetracker.users.application.search;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import ar.edu.ungs.carservicetracker.services.application.ServiceResponse;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import ar.edu.ungs.carservicetracker.users.application.UserResponse;
import ar.edu.ungs.carservicetracker.users.domain.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserSearcher {
    private final UserRepository repository;

    public UserSearcher(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserResponse> execute() {
        return this.repository.searchAll()
                              .stream()
                              .map(UserResponse::map)
                              .toList();
    }
}
