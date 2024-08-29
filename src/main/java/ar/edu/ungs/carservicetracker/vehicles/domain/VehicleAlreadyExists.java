package ar.edu.ungs.carservicetracker.vehicles.domain;

public class VehicleAlreadyExists extends RuntimeException {
    private final String code;

    public VehicleAlreadyExists() {
        super("This Vehicle Already Exists");
        this.code = "duplicated_license_plate";
    }

    public String code() {
        return code;
    }
}
