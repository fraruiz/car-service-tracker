package ar.edu.ungs.carservicetracker.services.application;

public record UpdateServiceRequest(String id,
                                   String status,
                                   String description,
                                   ServiceAmountRequest amount,
                                   ServiceEstimationRequest estimation) {
    public static UpdateServiceRequest build(String id, UpdateServiceRequest request) {
        return new UpdateServiceRequest(id, request.status, request.description, request.amount, request.estimation);
    }
}
