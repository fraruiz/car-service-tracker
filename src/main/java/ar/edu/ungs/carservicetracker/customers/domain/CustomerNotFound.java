package ar.edu.ungs.carservicetracker.customers.domain;

public class CustomerNotFound extends RuntimeException {
    private final String code;

    public CustomerNotFound() {
        super("customer not found");
        this.code = "not_found";
    }
}
