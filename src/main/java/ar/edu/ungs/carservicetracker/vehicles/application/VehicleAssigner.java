package ar.edu.ungs.carservicetracker.vehicles.application;

import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerNotFound;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleNotFound;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleRepository;
import org.springframework.stereotype.Component;

@Component
public class VehicleAssigner {

    private final VehicleRepository vehicleRepository;
    private final CustomerRepository customerRepository;

    public VehicleAssigner(VehicleRepository vehicleRepository, CustomerRepository customerRepository) {
        this.vehicleRepository = vehicleRepository;
        this.customerRepository = customerRepository;

    }

    public void assign(String VehicleId, String customerId) throws VehicleNotFound {

        var vehicle =  this.vehicleRepository.findById(new VehicleId(VehicleId)).orElseThrow(VehicleNotFound::new);
        var customer = this.customerRepository.findById(new CustomerId(customerId)).orElseThrow(CustomerNotFound::new);

        customer.addVehicle(vehicle.id().value());
    }





}
