package ar.edu.ungs.carservicetracker.services.application;

import ar.edu.ungs.carservicetracker.customers.application.CustomerResponse;
import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.users.application.UserResponse;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record ServiceResponse(String id,
                              String description,
                              String status,
                              Integer estimation,
                              //ServiceEstimationResponse estimation,
                              BigDecimal amount,
                              //ServiceAmountResponse amount,
                                String mechanic_id,
                                String customer_id,
                              //  UserResponse mechanic_id,
                             // CustomerResponse customer_id,
                              LocalDate dateCreated,
                              LocalDate dateUpdated) {
    public static ServiceResponse map(Service service) {
        return new ServiceResponse(service.id().value(),
                service.description().value(),
                service.status().name(),
                service.estimation().value(),
                //ServiceEstimationResponse.map(service.estimation()),
                service.amount().totalAmount(),
                //ServiceAmountResponse.map(service.amount()),
                service.mechanic().username().value(),
                // UserResponse.map(service.mechanic()),
                service.customer().fullName().value(),
                //CustomerResponse.map(service.customer()),
                service.dateCreated(),
                service.dateUpdated());
    }
}
