package ar.edu.ungs.carservicetracker.services.application;

import java.math.BigDecimal;

public record ServiceAmountRequest(BigDecimal costsAmount,
                                   BigDecimal laborAmount) {
}
