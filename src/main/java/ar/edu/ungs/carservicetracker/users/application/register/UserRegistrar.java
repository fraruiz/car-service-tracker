package ar.edu.ungs.carservicetracker.users.application.register;

import ar.edu.ungs.carservicetracker.users.application.UserRequest;
import ar.edu.ungs.carservicetracker.users.domain.*;
import org.springframework.stereotype.Component;

@Component
public final class UserRegistrar {
    private final UserFinder userFinder;
    private final UserRepository repository;

    public UserRegistrar(UserFinder userFinder, UserRepository repository) {
        this.userFinder = userFinder;
        this.repository = repository;
    }

    public void execute(UserRequest request) {
        Username username = new Username(request.username());

        ensureNotExists(username);

        User user = User.create(request.id(), request.type(), request.username(), request.password(), request.garageId());

        this.repository.save(user);
    }

    private void ensureNotExists(Username username) {
        try {
            this.userFinder.execute(username);

            throw new UserFound(username);
        } catch (UserNotFound ignored) {

        }
    }
}
