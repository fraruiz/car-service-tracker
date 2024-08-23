package ar.edu.ungs.carservicetracker.customers.domain;

public record Customer(Long id, String fullname, String email) {

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
