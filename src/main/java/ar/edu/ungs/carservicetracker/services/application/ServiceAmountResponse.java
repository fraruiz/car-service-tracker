package ar.edu.ungs.carservicetracker.services.application;

import ar.edu.ungs.carservicetracker.services.domain.ServiceAmount;

import java.math.BigDecimal;

public record ServiceAmountResponse(BigDecimal costsAmount,
                                    BigDecimal laborAmount,
                                    BigDecimal totalAmount) {
    public static ServiceAmountResponse map(ServiceAmount amount) {
        return new ServiceAmountResponse(amount.costsAmount(), amount.laborAmount(), amount.totalAmount());
    }
}
