package ar.edu.ungs.carservicetracker.users.application.find;

import ar.edu.ungs.carservicetracker.users.application.UserResponse;
import ar.edu.ungs.carservicetracker.users.domain.*;
import ar.edu.ungs.carservicetracker.users.domain.services.DomainUserFinder;
import org.springframework.stereotype.Component;

@Component
public final class UserFinder {
    private final DomainUserFinder finder;

    public UserFinder(DomainUserFinder finder) {
        this.finder = finder;
    }

    public UserResponse execute(String id) {
        User user =  this.finder.execute(new UserId(id));

        return UserResponse.map(user);
    }


}
