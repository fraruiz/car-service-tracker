package ar.edu.ungs.carservicetracker.users.application.auth;

import ar.edu.ungs.carservicetracker.users.application.AuthUserRequest;
import ar.edu.ungs.carservicetracker.users.domain.*;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public final class UserAuthenticator {
    private final UserFinder userFinder;

    public UserAuthenticator(UserFinder userFinder) {
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
