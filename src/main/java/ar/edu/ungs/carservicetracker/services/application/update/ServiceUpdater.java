package ar.edu.ungs.carservicetracker.services.application.update;

import ar.edu.ungs.carservicetracker.services.application.UpdateServiceRequest;
import ar.edu.ungs.carservicetracker.services.application.find.ServiceFinder;
import ar.edu.ungs.carservicetracker.services.domain.*;
import ar.edu.ungs.carservicetracker.services.domain.services.DomainServiceFinder;
import org.springframework.stereotype.Component;

@Component
public final class ServiceUpdater {
    private final DomainServiceFinder finder;
    private final ServiceRepository serviceRepository;

    public ServiceUpdater(DomainServiceFinder finder, ServiceRepository serviceRepository) {
        this.finder = finder;
        this.serviceRepository = serviceRepository;
    }

    public void execute(UpdateServiceRequest request) {
        Service service = this.finder.execute(request.id());

        ServiceStatus statusToUpdate = ServiceStatus.valueOf(request.status());

        switch (statusToUpdate) {
            case IN_PROGRESS -> this.convertToInProgress(service, request);
            case FINISHED -> service.finish();
        }

        this.serviceRepository.save(service);
    }

    private void convertToInProgress(Service service, UpdateServiceRequest request) {
        ServiceDescription description = new ServiceDescription(request.description());
        ServiceAmount amount = new ServiceAmount(request.amount().costsAmount(), request.amount().laborAmount());
        ServiceEstimation estimation = new ServiceEstimation(ServiceEstimationUnit.valueOf(request.estimation().unit()), request.estimation().value());

        service.inProgress(description, amount, estimation);
    }
}
