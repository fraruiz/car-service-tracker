package ar.edu.ungs.carservicetracker.users.application.auth;

import ar.edu.ungs.carservicetracker.users.application.AuthUserRequest;
import ar.edu.ungs.carservicetracker.users.domain.*;
import ar.edu.ungs.carservicetracker.users.domain.services.DomainUserFinder;
import org.springframework.stereotype.Component;

@Component
public final class UserAuthenticator {
    private final DomainUserFinder userFinder;

    public UserAuthenticator(DomainUserFinder userFinder) {
        this.userFinder = userFinder;
    }

    public void execute(AuthUserRequest request) {
        Username username = new Username(request.username());
        Password password = new Password(request.password());

        User user = this.userFinder.execute(username);

        ensurePasswordValid(user, password, username);
    }

    private void ensurePasswordValid(User user, Password password, Username username) {
        if (user.isNotValidPassword(password)) {
            throw new UnauthorizedUser(username);
        }
    }
}
