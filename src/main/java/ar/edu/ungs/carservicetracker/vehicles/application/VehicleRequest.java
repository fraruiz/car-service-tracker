package ar.edu.ungs.carservicetracker.vehicles.application;

public record VehicleRequest(String id, String brand, String model) {
    @Override
    public String toString() {
        return "VehicleRequest{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }



}