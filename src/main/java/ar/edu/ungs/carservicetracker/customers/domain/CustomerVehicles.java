package ar.edu.ungs.carservicetracker.customers.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CustomerVehicles {
    private final List<String> vehicles;

    public CustomerVehicles() {
        this.vehicles = new ArrayList<>();
    }

    public List<String> values() {
        return this.vehicles;
    }

    public void add(String licensePlate) {
        this.vehicles.add(licensePlate);

    }
    public void remove(String licensePlate) {
        this.vehicles.remove(licensePlate);
    }

    @Override
    public String toString() {
        return "CustomerVehicles [vehicles=" + vehicles + "]";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerVehicles customerVehicles = (CustomerVehicles) o;
        return Objects.equals(vehicles, customerVehicles.vehicles);
    }
}
