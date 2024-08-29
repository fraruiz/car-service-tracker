package ar.edu.ungs.carservicetracker.customers.application;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.vehicles.application.VehicleResponse;

import java.util.List;

public record CustomerResponse(String id, String fullName, String email, List<VehicleResponse> vehicles) {

    public static CustomerResponse map(Customer customer) {
        return new CustomerResponse(customer.id().value(),
                                    customer.fullName().value(),
                                    customer.email().value(),
                                    customer.vehicles().stream().map(VehicleResponse::map).toList());
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles + '\'' +
                '}';
    }
}
