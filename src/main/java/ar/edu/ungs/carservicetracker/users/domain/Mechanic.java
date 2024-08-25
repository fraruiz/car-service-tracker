package ar.edu.ungs.carservicetracker.users.domain;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageId;

import java.util.Objects;

public final class Mechanic extends GarageUser {
    public Mechanic(UserId id,
                       Username username,
                       Password password,
                       Garage garage) {
        super(id, UserType.MECHANIC, username, password, garage);
    }
}
