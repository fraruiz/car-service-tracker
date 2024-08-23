package ar.edu.ungs.carservicetracker.customers.application;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;

public record CustomerResponse(Long id, String fullname, String email) {
    public static CustomerResponse map(Customer customer) {
        return new CustomerResponse(customer.id(), customer.fullname(), customer.email());
    }

    @Override
    public String toString() {
        return "CustomerResponse{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
