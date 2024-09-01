package ar.edu.ungs.carservicetracker.services.application.create;

import ar.edu.ungs.carservicetracker.customers.domain.services.DomainCustomerFinder;
import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.services.application.CreateServiceRequest;
import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import ar.edu.ungs.carservicetracker.users.domain.Mechanic;
import ar.edu.ungs.carservicetracker.users.domain.services.DomainUserFinder;
import ar.edu.ungs.carservicetracker.users.domain.UserId;
import ar.edu.ungs.carservicetracker.vehicles.domain.services.DomainVehicleFinder;
import ar.edu.ungs.carservicetracker.vehicles.domain.Vehicle;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import org.springframework.stereotype.Component;

@Component
public final class ServiceCreator {
    private final ServiceRepository repository;
    private final DomainUserFinder userFinder;
    private final DomainVehicleFinder vehicleFinder;
    private final DomainCustomerFinder customerFinder;

    public ServiceCreator(ServiceRepository repository,
                          DomainUserFinder userFinder,
                          DomainVehicleFinder vehicleFinder,
                          DomainCustomerFinder customerFinder) {
        this.repository = repository;
        this.userFinder = userFinder;
        this.vehicleFinder = vehicleFinder;
        this.customerFinder = customerFinder;
    }

    public void execute(CreateServiceRequest request) {
        Mechanic mechanic = (Mechanic) this.userFinder.execute(new UserId(request.mechanicId()));
        Customer customer = this.customerFinder.execute(new CustomerId(request.customerId()));
        Vehicle vehicle = this.vehicleFinder.execute(new VehicleId(request.vehicleId()));

        var service = Service.create(request.id(), mechanic, customer, vehicle);

        this.repository.save(service);
    }
}
