package ar.edu.ungs.carservicetracker.garages.domain;

public class GarageNotFound extends RuntimeException {
    private final String code;

    public GarageNotFound(Long id) {
        super(String.format("garage <%s> not found", id));
        this.code = "not_found";
    }
}
