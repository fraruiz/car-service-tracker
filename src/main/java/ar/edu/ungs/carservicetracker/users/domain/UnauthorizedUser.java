package ar.edu.ungs.carservicetracker.users.domain;

public class UnauthorizedUser extends RuntimeException {
    private final String code;

    public UnauthorizedUser(Username username) {
        super(String.format("user <%s> unauthorized", username.value()));
        this.code = "unauthorized";
    }

    public String code() {
        return code;
    }
}
