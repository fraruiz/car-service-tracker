package ar.edu.ungs.carservicetracker.vehicles.domain;

public class VehicleNotFound extends RuntimeException {
    private final String code;

    public VehicleNotFound() {
        super("vehicle not found");
        this.code = "not_found";
    }

    public String code() {
        return code;
    }
}
