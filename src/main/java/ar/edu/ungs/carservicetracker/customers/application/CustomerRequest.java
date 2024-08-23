package ar.edu.ungs.carservicetracker.customers.application;

public record CustomerRequest(Long id, String fullname, String email) {
    @Override
    public String toString() {
        return "CustomerRequest{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
