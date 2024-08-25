package ar.edu.ungs.carservicetracker.garages.domain;

public class GarageNotFound extends RuntimeException {
    private final String code;

    public GarageNotFound() {
        super("garage not found");
        this.code = "not_found";
    }

    public String getCode() {
        return code;
    }
}
