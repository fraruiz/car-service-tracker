package ar.edu.ungs.carservicetracker.customers.domain;

import java.util.Objects;

public final class Customer {
    private final CustomerId id;
    private final CustomerFullName fullName;
    private final Email email;
    private final CustomerVehicles vehicles;


    public Customer(CustomerId id, CustomerFullName fullName, Email email) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.vehicles = new CustomerVehicles();
    }

    public static Customer create(String id, String fullName, String email) {
        CustomerId customerCustomerId = new CustomerId(id);
        CustomerFullName customerCustomerFullName = new CustomerFullName(fullName);
        Email customerEmail = new Email(email);

        return new Customer(customerCustomerId, customerCustomerFullName, customerEmail);
    }

    public CustomerId id() {
        return id;
    }

    public CustomerFullName fullName() {
        return fullName;
    }

    public Email email() {
        return email;
    }

    public CustomerVehicles vehicles() {return vehicles;}

    public void addVehicle(String licensePlate){
        this.vehicles.add(licensePlate);

    }
    public void removeVehicle(String licensePlate){
        this.vehicles.remove(licensePlate);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(id, customer.id) && Objects.equals(fullName, customer.fullName) && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, email);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", vehicles=" + vehicles + '\'' +
                '}';
    }
}
