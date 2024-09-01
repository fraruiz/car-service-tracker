package ar.edu.ungs.carservicetracker.vehicles.application;

import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;


public record VehicleResponse(String id, String brand, String model) {

    public static VehicleResponse map(Vehicle vehicle) {
        return new VehicleResponse(vehicle.id().value(),
                                    vehicle.brand().value(),
                                    vehicle.model().value());
    }

    @Override
    public String toString() {
        return "VehicleRequest{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
