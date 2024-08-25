package ar.edu.ungs.carservicetracker.services.domain;

import java.math.BigDecimal;
import java.util.Objects;

public final class ServiceAmount {
    private final BigDecimal costsAmount;
    private final BigDecimal laborAmount;

    public ServiceAmount(BigDecimal costsAmount, BigDecimal laborAmount) {
        this.costsAmount = costsAmount;
        this.laborAmount = laborAmount;
    }

    public static ServiceAmount empty() {
        return new ServiceAmount(BigDecimal.ZERO, BigDecimal.ZERO);
    }

    public BigDecimal costsAmount() {
        return costsAmount;
    }

    public BigDecimal laborAmount() {
        return laborAmount;
    }

    public BigDecimal totalAmount() {
        return costsAmount.add(laborAmount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceAmount that = (ServiceAmount) o;
        return Objects.equals(costsAmount, that.costsAmount) && Objects.equals(laborAmount, that.laborAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(costsAmount, laborAmount);
    }

    @Override
    public String toString() {
        return "ServiceEstimation{" +
                "costsAmount=" + costsAmount +
                ", laborAmount=" + laborAmount +
                '}';
    }
}
