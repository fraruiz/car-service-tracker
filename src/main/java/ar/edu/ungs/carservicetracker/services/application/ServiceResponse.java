package ar.edu.ungs.carservicetracker.services.application;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.users.application.UserResponse;

import java.time.LocalDateTime;

public record ServiceResponse(String id,
                              String description,
                              String status,
                              ServiceEstimationResponse estimation,
                              ServiceAmountResponse amount,
                              UserResponse mechanic,
                              CustomerResponse customer,
                              LocalDateTime dateCreated,
                              LocalDateTime dateUpdated) {
    public static ServiceResponse map(Service service) {
        return new ServiceResponse(service.id().value(),
                service.description().value(),
                service.status().name(),
                ServiceEstimationResponse.map(service.estimation()),
                ServiceAmountResponse.map(service.amount()),
                UserResponse.map(service.mechanic()),
                CustomerResponse.map(service.customer()),
                service.dateCreated(),
                service.dateUpdated());
    }
}
