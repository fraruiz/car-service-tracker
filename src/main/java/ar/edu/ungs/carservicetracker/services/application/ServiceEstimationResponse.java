package ar.edu.ungs.carservicetracker.services.application;

import ar.edu.ungs.carservicetracker.services.domain.ServiceEstimation;

public record ServiceEstimationResponse(String unit,
                                        Integer value) {
    public static ServiceEstimationResponse map(ServiceEstimation estimation) {
        return new ServiceEstimationResponse(estimation.unit().name(), estimation.value());
    }
}
