package ar.edu.ungs.carservicetracker.services.application.find;

import ar.edu.ungs.carservicetracker.services.application.ServiceResponse;
import ar.edu.ungs.carservicetracker.services.domain.ServiceId;
import ar.edu.ungs.carservicetracker.services.domain.ServiceNotFound;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import org.springframework.stereotype.Component;

@Component
public final class ServiceFinder {
    private final ServiceRepository repository;

    public ServiceFinder(ServiceRepository repository) {
        this.repository = repository;
    }

    public ServiceResponse execute(String id) {
        return this.repository.findById(new ServiceId(id))
                              .map(ServiceResponse::map)
                              .orElseThrow(ServiceNotFound::new);
    }
}
