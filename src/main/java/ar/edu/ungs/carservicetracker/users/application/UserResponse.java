package ar.edu.ungs.carservicetracker.users.application;

import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.users.domain.GarageAdmin;
import ar.edu.ungs.carservicetracker.users.domain.GarageUser;
import ar.edu.ungs.carservicetracker.users.domain.Mechanic;
import ar.edu.ungs.carservicetracker.users.domain.User;

public record UserResponse(String id, String type, String username, GarageResponse garage) {
    public static UserResponse map(User user) {
        return new UserResponse(user.id().value(),
                user.type().name(),
                user.username().value(),
                user instanceof GarageUser ? GarageResponse.map(((GarageUser) user).garage()) : null);
    }
}
