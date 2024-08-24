package ar.edu.ungs.carservicetracker.vehicles.domain;

public class VehicleNotFound extends RuntimeException {
    private final String code;

    public VehicleNotFound(Long id) {
        super(String.format("vehicle <%s> not found", id));
        this.code = "not_found";
    }

    public VehicleNotFound(String l_plate) {
        super(String.format("vehicle <%s> not found", l_plate));
        this.code = "not_found";
    }
}
