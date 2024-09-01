package ar.edu.ungs.carservicetracker.customers.application;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;

public record CustomerResponse(String id, String fullName, String email) {

    public static CustomerResponse map(Customer customer) {
        return new CustomerResponse(customer.id().value(),
                                    customer.fullName().value(),
                                    customer.email().value());
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
