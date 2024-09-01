package ar.edu.ungs.carservicetracker.services.domain;

import ar.edu.ungs.carservicetracker.shared.domain.Pagination;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);

    Optional<Service> findById(ServiceId id);

    Pagination<Service> match(ServiceCriteria criteria);

    List<Service> searchAll();
}
