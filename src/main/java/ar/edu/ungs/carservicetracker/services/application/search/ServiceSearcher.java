package ar.edu.ungs.carservicetracker.services.application.search;

import ar.edu.ungs.carservicetracker.garages.application.GarageResponse;
import ar.edu.ungs.carservicetracker.services.application.ServiceResponse;
import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.services.domain.ServiceCriteria;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import ar.edu.ungs.carservicetracker.shared.domain.Pagination;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public final class ServiceSearcher {
    private final ServiceRepository repository;

    public ServiceSearcher(ServiceRepository repository) {
        this.repository = repository;
    }

    public Pagination<ServiceResponse> execute(ServiceCriteria criteria) {
        Pagination<Service> pagination = this.repository.match(criteria);

        List<ServiceResponse> values = pagination.values()
                                                  .stream()
                                                  .map(ServiceResponse::map)
                                                  .toList();

        return new Pagination<>(pagination.size(), pagination.page(), values);
    }

    public List<ServiceResponse> execute() {
        return this.repository.searchAll()
                              .stream()
                              .map(ServiceResponse::map)
                              .toList();
    }

}
