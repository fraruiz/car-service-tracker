package ar.edu.ungs.carservicetracker.vehicles.domain;


import java.util.Objects;

public final class Vehicle {
    private final VehicleId id;
    private final VehicleLicensePlate licensePlate;
    private final VehicleBrand brand;
    private final VehicleModel model;
    private final int mileage;

    //TODO: Agregar Lista de caracteristicas extendidas de la ficha tecnica? (Motor, transmision, tipo de combustible, etc)


    public Vehicle(VehicleId id, VehicleLicensePlate licensePlate, VehicleBrand brand, VehicleModel model, int mileage) {
        this.id = id;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.mileage = mileage;
    }

    public static Vehicle create(String id, String L_plate, String brand, String model, int mileage) {
        VehicleId VehicleId = new VehicleId(id);
        VehicleLicensePlate value = new VehicleLicensePlate(L_plate);
        VehicleBrand brandValue = new VehicleBrand(brand);
        VehicleModel modelValue = new VehicleModel(model);

        return new Vehicle(VehicleId, value, brandValue, modelValue, mileage);
    }

    public VehicleId id() {
        return id;
    }

    public VehicleLicensePlate licensePlate() {
        return licensePlate;
    }

    public VehicleBrand brand() {
        return  brand;
    }

    public VehicleModel model() {
        return model;
    }

    public int mileage() {
        return mileage;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id)
                && Objects.equals(licensePlate, vehicle.licensePlate)
                    && Objects.equals(brand, vehicle.brand)
                    && Objects.equals(model, vehicle.model) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licensePlate, brand, model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", Domain='" + licensePlate + '\'' +
                ", brand=" + brand + '\'' +
                ", model=" + model + '\'' +
                ", mileage=" + mileage + '\'' +
                '}';
    }
}
