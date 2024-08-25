package ar.edu.ungs.carservicetracker.users.domain.services;

import ar.edu.ungs.carservicetracker.users.domain.*;
import org.springframework.stereotype.Component;

@Component
public final class DomainUserFinder {
    private final UserRepository repository;

    public DomainUserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(Username username) {
        return this.repository.findByUsername(username)
                              .orElseThrow(UserNotFound::new);
    }

    public User execute(UserId id) {
        return this.repository.findById(id)
                .orElseThrow(UserNotFound::new);
    }
}
