package ar.edu.ungs.carservicetracker.garages.application;

public record GarageRequest(String id, String garageName) {
    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", fullName='" + garageName + '\'' +

                '}';
    }
}
