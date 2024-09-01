package ar.edu.ungs.carservicetracker.vehicles.domain;


import java.util.Objects;

public final class Vehicle {
    private final VehicleId id;
    private final VehicleBrand brand;
    private final VehicleModel model;

    public Vehicle(VehicleId id, VehicleBrand brand, VehicleModel model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public static Vehicle create(String id, String brand, String model) {
        VehicleId VehicleId = new VehicleId(id);
        VehicleBrand brandValue = new VehicleBrand(brand);
        VehicleModel modelValue = new VehicleModel(model);

        return new Vehicle(VehicleId, brandValue, modelValue);
    }

    public VehicleId id() {
        return id;
    }

    public VehicleBrand brand() {
        return  brand;
    }

    public VehicleModel model() {
        return model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id)
                    && Objects.equals(brand, vehicle.brand)
                    && Objects.equals(model, vehicle.model) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand=" + brand + '\'' +
                ", model=" + model + '\'' +
                '}';
    }
}
