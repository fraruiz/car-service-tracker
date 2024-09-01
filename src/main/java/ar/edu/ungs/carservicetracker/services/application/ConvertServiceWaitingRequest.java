package ar.edu.ungs.carservicetracker.services.application;

public record ConvertServiceWaitingRequest(String id, String description, ServiceAmountRequest amount, ServiceEstimationRequest estimation) {
}
