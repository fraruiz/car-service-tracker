package ar.edu.ungs.carservicetracker.users.domain;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;

import java.util.Objects;

public final class GarageAdmin extends GarageUser {
    public GarageAdmin(UserId id,
                       Username username,
                       Password password,
                       Garage garage) {
        super(id, UserType.GARAGE_ADMIN, username, password, garage);
    }
}
