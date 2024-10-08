package ar.edu.ungs.carservicetracker.services.domain;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.users.domain.Mechanic;
import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public final class Service {
    private final ServiceId id;
    private ServiceStatus status;
    private ServiceDescription description;
    private ServiceEstimation estimation;
    private ServiceAmount amount;
    private final Mechanic mechanic;
    private final Vehicle vehicle;
    private final Customer customer;

    public Service(ServiceId id,
                   ServiceStatus status,
                   ServiceDescription description,
                   ServiceEstimation estimation,
                   ServiceAmount amount,
                   Mechanic mechanic,
                   Vehicle vehicle,
                   Customer customer) {
        this.id = id;
        this.status = status;
        this.description = description;
        this.estimation = estimation;
        this.amount = amount;
        this.mechanic = mechanic;
        this.vehicle = vehicle;
        this.customer = customer;
    }

    public static Service create(String id, Mechanic mechanic, Customer customer, Vehicle vehicle) {
        return new Service(new ServiceId(id),
                ServiceStatus.PENDING,
                ServiceDescription.empty(),
                ServiceEstimation.empty(),
                ServiceAmount.empty(),
                mechanic,
                vehicle,
                customer);
    }

    public ServiceId id() {
        return id;
    }

    public ServiceStatus status() {
        return status;
    }

    public void finish() {
        this.status = ServiceStatus.FINISHED;
    }

    public void inProgress(ServiceDescription description,
                           ServiceAmount amount,
                           ServiceEstimation estimation) {
        this.status = ServiceStatus.IN_PROGRESS;
        this.description = description;
        this.amount = amount;
        this.estimation = estimation;
    }

    public ServiceDescription description() {
        return description;
    }

    public ServiceEstimation estimation() {
        return estimation;
    }

    public ServiceAmount amount() {
        return amount;
    }

    public Mechanic mechanic() {
        return mechanic;
    }

    public Vehicle vehicle() {
        return vehicle;
    }

    public Customer customer() {
        return customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(id, service.id) && status == service.status && Objects.equals(description, service.description) && Objects.equals(estimation, service.estimation) && Objects.equals(amount, service.amount) && Objects.equals(mechanic, service.mechanic) && Objects.equals(vehicle, service.vehicle) && Objects.equals(customer, service.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, description, estimation, amount, mechanic, vehicle, customer);
    }

    @Override
    public String toString() {
        return "Service{" +
                "id=" + id +
                ", status=" + status +
                ", description=" + description +
                ", estimation=" + estimation +
                ", amount=" + amount +
                ", mechanic=" + mechanic +
                ", vehicle=" + vehicle +
                ", customer=" + customer +
                '}';
    }
}
