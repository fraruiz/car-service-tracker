package ar.edu.ungs.carservicetracker.services.domain;

import java.util.Objects;

public final class ServiceEstimation {
    private final ServiceEstimationUnit unit;
    private final Integer value;

    public ServiceEstimation(ServiceEstimationUnit unit, Integer value) {
        this.unit = unit;
        this.value = value;
    }

    public static ServiceEstimation empty() {
        return new ServiceEstimation(ServiceEstimationUnit.HOURS, 0);
    }

    public ServiceEstimationUnit unit() {
        return unit;
    }

    public Integer value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceEstimation that = (ServiceEstimation) o;
        return unit == that.unit && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(unit, value);
    }

    @Override
    public String toString() {
        return "ServiceEstimation{" +
                "unit=" + unit +
                ", value=" + value +
                '}';
    }
}
