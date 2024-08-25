package ar.edu.ungs.carservicetracker.users.domain;

public final class Admin extends User {
    public Admin(UserId id, Username username, Password password) {
        super(id, UserType.ADMIN, username, password);
    }
}
