package ar.edu.ungs.carservicetracker.garages.domain;

import java.util.Objects;

public final class GarageName {
    private final String value;

    public GarageName(String value) { // Set
        this.value = value;

    }

    public String value() {

        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GarageName garagename = (GarageName) o; // // "cast" del objeto 'o' al tipo GarageFullName
        return Objects.equals(value, garagename.value); // se compara el valor interno (value) de ambos objetos usando el método Objects.equals
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "GarageName{" +
                "value='" + value + '\'' +
                '}';
    }
}
