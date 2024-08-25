package ar.edu.ungs.carservicetracker.users.domain;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;

import java.util.Objects;

public abstract class GarageUser extends User {
    private final Garage garage;

    public GarageUser(UserId id,
                      UserType type,
                      Username username,
                      Password password,
                      Garage garage) {
        super(id, type, username, password);
        this.garage = garage;
    }

    public Garage garage() {
        return garage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GarageUser that = (GarageUser) o;
        return Objects.equals(garage, that.garage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), garage);
    }

    @Override
    public String toString() {
        return "GarageUser{" +
                "garage=" + garage +
                '}';
    }
}
