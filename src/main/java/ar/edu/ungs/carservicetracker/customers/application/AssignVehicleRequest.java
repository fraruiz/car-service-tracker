package ar.edu.ungs.carservicetracker.customers.application;

public record AssignVehicleRequest(String customerId, String vehicleId) {
    @Override
    public String toString() {
        return "AssignVehicle{" +
                "customerId='" + customerId + '\'' +
                ", vehicleId='" + vehicleId + '\'' +
                '}';
    }
}
