package ar.edu.ungs.carservicetracker.users.domain;

public final class UserFound extends RuntimeException {
    private final String code;

    public UserFound(Username username) {
        super(String.format("the username <%s> is using", username.value()));
        this.code = "not_found";
    }

    public String code() {
        return code;
    }
}
