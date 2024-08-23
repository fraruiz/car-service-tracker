package ar.edu.ungs.carservicetracker.customers.domain;

public class CustomerNotFound extends RuntimeException {
    private final String code;

    public CustomerNotFound(Long id) {
        super(String.format("customer <%s> not found", id));
        this.code = "not_found";
    }
}
