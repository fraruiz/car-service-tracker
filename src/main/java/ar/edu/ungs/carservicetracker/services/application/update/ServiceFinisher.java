package ar.edu.ungs.carservicetracker.services.application.update;

import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.services.domain.services.DomainServiceFinder;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import org.springframework.stereotype.Component;

@Component
public final class ServiceFinisher {
    private final ServiceRepository repository;
    private final DomainServiceFinder finder;

    public ServiceFinisher(ServiceRepository repository, DomainServiceFinder finder) {
        this.repository = repository;
        this.finder = finder;
    }

    public void execute(String id) {
        Service service = this.finder.execute(id);

        service.finish();

        this.repository.save(service);

        //TODO: Send email
    }
}
