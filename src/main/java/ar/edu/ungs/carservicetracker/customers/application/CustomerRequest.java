package ar.edu.ungs.carservicetracker.customers.application;

public record CustomerRequest(String id, String fullname, String email) {
    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", fullName='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
