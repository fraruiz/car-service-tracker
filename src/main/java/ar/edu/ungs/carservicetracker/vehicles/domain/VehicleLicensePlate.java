package ar.edu.ungs.carservicetracker.vehicles.domain;

import java.util.Objects;

public final class VehicleLicensePlate {
    private final String value;

    public VehicleLicensePlate(String value) { // Set
        this.value = value;

    }

    public String value() {

        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VehicleLicensePlate LicensePlate = (VehicleLicensePlate) o; // // "cast" del objeto 'o' al tipo VehicleDomain
        return Objects.equals(value, LicensePlate.value); // se compara el valor interno (value) de ambos objetos usando el método Objects.equals
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "VehicleLicensePlate{" +
                "value='" + value + '\'' +
                '}';
    }
}
