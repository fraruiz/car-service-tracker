package ar.edu.ungs.carservicetracker.services.application.update;

import ar.edu.ungs.carservicetracker.services.application.ConvertServiceInProgressRequest;
import ar.edu.ungs.carservicetracker.services.domain.*;
import ar.edu.ungs.carservicetracker.services.domain.services.DomainServiceFinder;
import org.springframework.stereotype.Component;

@Component
public final class InProgressServiceConverter {
    private final ServiceRepository repository;
    private final DomainServiceFinder finder;

    public InProgressServiceConverter(ServiceRepository repository, DomainServiceFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id, ConvertServiceInProgressRequest request) {
        Service service = this.finder.execute(id);

        ServiceDescription description = new ServiceDescription(request.description());
        ServiceAmount amount = new ServiceAmount(request.amount().costsAmount(), request.amount().laborAmount());
        ServiceEstimation estimation = new ServiceEstimation(ServiceEstimationUnit.valueOf(request.estimation().unit()), request.estimation().value());

        service.inProgress(description, amount, estimation);

        this.repository.save(service);

        //TODO: Enviar mail al customer
    }
}
