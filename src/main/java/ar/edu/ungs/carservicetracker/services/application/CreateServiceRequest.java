package ar.edu.ungs.carservicetracker.services.application;

public record CreateServiceRequest(String id,
                                   String mechanicId,
                                   String vehicleId,
                                   String customerId) {
}
