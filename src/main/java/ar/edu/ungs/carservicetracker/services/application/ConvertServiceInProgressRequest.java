package ar.edu.ungs.carservicetracker.services.application;

public record ConvertServiceInProgressRequest(String description, ServiceAmountRequest amount, ServiceEstimationRequest estimation) {
}
