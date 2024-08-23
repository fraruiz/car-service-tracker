package ar.edu.ungs.carservicetracker.users.domain;

import ar.edu.ungs.carservicetracker.garages.domain.GarageId;

import java.util.Objects;

public final class GarageAdmin extends User {
    private final GarageId garageId;

    public GarageAdmin(UserId id,
                       Username username,
                       Password password,
                       GarageId garageId) {
        super(id, UserType.GARAGE_ADMIN, username, password);
        this.garageId = garageId;
    }

    public GarageId garageId() {
        return garageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        GarageAdmin that = (GarageAdmin) o;
        return Objects.equals(garageId, that.garageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), garageId);
    }

    @Override
    public String toString() {
        return "GarageAdmin{" +
                "garageId=" + garageId +
                '}';
    }
}
