package ar.edu.ungs.carservicetracker.users.domain;

public final class UserNotFound extends RuntimeException {
    private final String code;

    public UserNotFound() {
        super("user not found");
        this.code = "not_found";
    }

    public String code() {
        return code;
    }
}
