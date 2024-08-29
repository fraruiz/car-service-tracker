package ar.edu.ungs.carservicetracker.vehicles.application;

import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;


public record VehicleResponse(String id, String licensePlate, String brand, String model, int mileage) {

    public static VehicleResponse map(Vehicle vehicle) {
        return new VehicleResponse(vehicle.id().value(),
                                    vehicle.licensePlate().value(),
                                    vehicle.brand().value(),
                                    vehicle.model().value(),
                                    vehicle.mileage());
    }

    @Override
    public String toString() {
        return "VehicleRequest{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", mileage=" + mileage +
                '}';
    }
}
