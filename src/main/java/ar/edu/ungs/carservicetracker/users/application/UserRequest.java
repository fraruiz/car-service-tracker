package ar.edu.ungs.carservicetracker.users.application;

public record UserRequest(String id, String type, String username, String password, String garageId) {
}
