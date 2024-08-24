package ar.edu.ungs.carservicetracker.garages.application;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;

public record GarageResponse(String id, String name ) {
    public static GarageResponse map(Garage garage) {
        return new GarageResponse(garage.id().value(), garage.garageName().value());
    }

    @Override
    public String toString() {
        return "GarageResponse{" +
                "id=" + id +
                ", Name='" + name + '\'' +

                '}';
    }
}
