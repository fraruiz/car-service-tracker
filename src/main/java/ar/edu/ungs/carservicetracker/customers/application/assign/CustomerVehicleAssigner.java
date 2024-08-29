package ar.edu.ungs.carservicetracker.customers.application.assign;

import ar.edu.ungs.carservicetracker.customers.application.AssignVehicleRequest;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.services.DomainCustomerFinder;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.services.DomainVehicleFinder;
import org.springframework.stereotype.Component;

@Component
public class CustomerVehicleAssigner {
    private final DomainVehicleFinder vehicleFinder;
    private final DomainCustomerFinder customerFinder;

    public CustomerVehicleAssigner(DomainVehicleFinder vehicleFinder,
                                   DomainCustomerFinder customerFinder) {
        this.vehicleFinder = vehicleFinder;
        this.customerFinder = customerFinder;
    }

    public void execute(AssignVehicleRequest request) {
        var customer = customerFinder.execute(new CustomerId(request.customerId()));
        var vehicle =  vehicleFinder.execute(new VehicleId(request.vehicleId()));

        customer.addVehicle(vehicle);
    }
}
