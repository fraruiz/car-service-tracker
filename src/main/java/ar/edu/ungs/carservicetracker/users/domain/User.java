package ar.edu.ungs.carservicetracker.users.domain;

import ar.edu.ungs.carservicetracker.garages.domain.GarageId;

import java.util.Objects;

public abstract class User {
    private final UserId id;
    private final UserType type;
    private final Username username;
    private final Password password;

    public User(UserId id, UserType type, Username username, Password password) {
        this.id = id;
        this.type = type;
        this.username = username;
        this.password = password;
    }

    public static User create(String id, String type, String username, String password, String garageId) {
        UserType userType = UserType.valueOf(type);

        return switch (userType) {
            case ADMIN -> new Admin(new UserId(id), new Username(username), new Password(password));
            case GARAGE_ADMIN -> new GarageAdmin(new UserId(id), new Username(username), new Password(password), new GarageId(id));
            case MECHANIC -> new Mechanic(new UserId(id), new Username(username), new Password(password), new GarageId(id));
        };
    }

    public UserId id() {
        return id;
    }

    public UserType type() {
        return type;
    }

    public Username username() {
        return username;
    }

    public Password password() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && type == user.type && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", type=" + type +
                ", username=" + username +
                ", password=" + password +
                '}';
    }

    public boolean isNotValidPassword(Password password) {
        return !this.password.equals(password);
    }
}
