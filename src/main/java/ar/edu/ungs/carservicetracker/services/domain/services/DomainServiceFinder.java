package ar.edu.ungs.carservicetracker.services.domain.services;

import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.services.domain.ServiceId;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import org.springframework.stereotype.Component;

@Component
public final class DomainServiceFinder {
    private final ServiceRepository repository;

    public DomainServiceFinder(ServiceRepository repository) {
        this.repository = repository;
    }

    public Service execute(String id) {
        return this.repository.findById(new ServiceId(id))
                              .orElseThrow(ServiceNotFound::new);
    }
}
