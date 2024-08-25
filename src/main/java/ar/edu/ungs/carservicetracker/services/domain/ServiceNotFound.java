package ar.edu.ungs.carservicetracker.services.domain;

public class ServiceNotFound extends RuntimeException {
    private final String code;

    public ServiceNotFound() {
        super("user not found");
        this.code = "not_found";
    }

    public String code() {
        return code;
    }
}
