package ar.edu.ungs.carservicetracker.users.application.register;

import ar.edu.ungs.carservicetracker.garages.application.find.GarageFinder;
import ar.edu.ungs.carservicetracker.garages.domain.DomainGarageFinder;
import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageNotFound;
import ar.edu.ungs.carservicetracker.users.application.UserRequest;
import ar.edu.ungs.carservicetracker.users.domain.*;
import ar.edu.ungs.carservicetracker.users.domain.services.DomainUserFinder;
import org.springframework.stereotype.Component;

import java.security.InvalidParameterException;

@Component
public final class UserRegistrar {
    private final DomainUserFinder userFinder;
    private final DomainGarageFinder garageFinder;
    private final UserRepository repository;

    public UserRegistrar(DomainUserFinder userFinder,
                         DomainGarageFinder garageFinder,
                         UserRepository repository) {
        this.userFinder = userFinder;
        this.garageFinder = garageFinder;
        this.repository = repository;
    }

    public void execute(UserRequest request) {
        Username username = new Username(request.username());

        ensureNotExists(username);

        Garage garage = this.findGarageById(request.type(), request.garageId());

        User user = User.create(request.id(), request.type(), request.username(), request.password(), garage);

        this.repository.save(user);
    }

    private Garage findGarageById(String type, String garageId) {
        if (UserType.ADMIN.name().equals(type)) {
            return null;
        }

        if (garageId == null) {
            throw new InvalidParameterException("garageId cannot be null");
        }

        return this.garageFinder.execute(garageId);
    }

    private void ensureNotExists(Username username) {
        try {
            this.userFinder.execute(username);

            throw new UserFound(username);
        } catch (UserNotFound ignored) {

        }
    }
}
