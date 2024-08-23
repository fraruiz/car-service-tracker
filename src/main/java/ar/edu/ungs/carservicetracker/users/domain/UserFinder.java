package ar.edu.ungs.carservicetracker.users.domain;

import org.springframework.stereotype.Component;

@Component
public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository) {
        this.repository = repository;
    }

    public User execute(Username username) {
        return this.repository.findByUsername(username)
                              .orElseThrow(UserNotFound::new);
    }
}
