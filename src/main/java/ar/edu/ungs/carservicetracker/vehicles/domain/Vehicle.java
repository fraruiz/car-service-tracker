package ar.edu.ungs.carservicetracker.vehicles.domain;


import java.util.Objects;

public final class Vehicle {
    private final VehicleId id;
    private final VehicleLicensePlate vehicleDomain;
    private final VehicleBrand brand;
    private final VehicleModel model;
    private int mileage;


    // Agregar Lista de caracteristicas extendidas de la ficha tecnica? (Motor, transmision, tipo de combustible, etc)



    public Vehicle(VehicleId id, VehicleLicensePlate vehicleDomain, VehicleBrand brand, VehicleModel model, int mileage) {
        this.id = id;
        this.vehicleDomain = vehicleDomain;
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
    //Getters
    public VehicleId id() {return id;}
    public VehicleLicensePlate vehicleDomain() {
        return vehicleDomain;
    }
    public VehicleBrand brand() {return  brand;}
    public VehicleModel model() {return model;}
    public int mileage() {return mileage;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id)
                    && Objects.equals(vehicleDomain, vehicle.vehicleDomain)
                    && Objects.equals(brand, vehicle.brand)
                    && Objects.equals(model, vehicle.model) ;

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicleDomain, brand, model);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", Domain='" + vehicleDomain + '\'' +
                ", brand=" + brand + '\'' +
                ", model=" + model + '\'' +
                ", mileage=" + mileage + '\'' +
                '}';
    }
}
