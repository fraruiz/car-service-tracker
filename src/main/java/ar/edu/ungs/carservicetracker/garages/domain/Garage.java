package ar.edu.ungs.carservicetracker.garages.domain;

import java.util.Objects;

public final class Garage {
    private final GarageId id;
    private final GarageName name;

    public Garage(GarageId id, GarageName name) {
        this.id = id;
        this.name = name;
    }

    public static Garage create(String id, String name) {
        GarageId GarageId = new GarageId(id);
        GarageName value = new GarageName(name);


        return new Garage(GarageId, value);
    }

    public GarageId id() {
        return id;
    }

    public GarageName name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return Objects.equals(id, garage.id) && Objects.equals(name, garage.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }
}
