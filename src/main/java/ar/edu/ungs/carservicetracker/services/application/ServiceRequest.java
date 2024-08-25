package ar.edu.ungs.carservicetracker.services.application;

public record ServiceRequest(String id,
                            String mechanicId,
                            String vehicleId,
                            String customerId) {
}
