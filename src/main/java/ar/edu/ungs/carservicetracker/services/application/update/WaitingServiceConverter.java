package ar.edu.ungs.carservicetracker.services.application.update;


import ar.edu.ungs.carservicetracker.services.application.ConvertServiceWaitingRequest;
import ar.edu.ungs.carservicetracker.services.domain.*;
import ar.edu.ungs.carservicetracker.services.domain.services.DomainServiceFinder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public final class WaitingServiceConverter {
    private final ServiceRepository repository;
    private final DomainServiceFinder finder;

    public WaitingServiceConverter(ServiceRepository repository, DomainServiceFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, ConvertServiceWaitingRequest request) {
        Service service = this.finder.execute(id);

        ServiceDescription description = new ServiceDescription(request.description());
//        ServiceAmount amount = new ServiceAmount(request.amount().costsAmount(), request.amount().laborAmount());
        ServiceAmount amount = new ServiceAmount(new BigDecimal(0),new BigDecimal(0));

        ServiceEstimation estimation = new ServiceEstimation(ServiceEstimationUnit.valueOf(request.estimation().unit()), request.estimation().value());

        service.waiting(description, amount, estimation);

        this.repository.save(service);

        //TODO: Enviar mail al customer
    }
}
