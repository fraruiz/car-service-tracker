package ar.edu.ungs.carservicetracker.services.domain;

import java.util.Objects;

public final class ServiceDescription {
    private final String value;

    public ServiceDescription(String value) {
        this.value = value;
    }

    public static ServiceDescription empty() {
        return new ServiceDescription("");
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceDescription that = (ServiceDescription) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    @Override
    public String toString() {
        return "ServiceDescription{" +
                "value='" + value + '\'' +
                '}';
    }
}
