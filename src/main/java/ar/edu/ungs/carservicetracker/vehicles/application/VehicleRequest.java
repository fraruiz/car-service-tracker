package ar.edu.ungs.carservicetracker.vehicles.application;

public record VehicleRequest(String id,  String licensePlate, String brand, String model, int mileage) {
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