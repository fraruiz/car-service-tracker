package ar.edu.ungs.carservicetracker.services.infrastructure.persistence;

import ar.edu.ungs.carservicetracker.services.domain.Service;
import ar.edu.ungs.carservicetracker.services.domain.ServiceCriteria;
import ar.edu.ungs.carservicetracker.services.domain.ServiceId;
import ar.edu.ungs.carservicetracker.services.domain.ServiceRepository;
import ar.edu.ungs.carservicetracker.shared.domain.Pagination;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public final class InMemoryServiceRepository implements ServiceRepository {
    private final Map<String, Service> values;

    public InMemoryServiceRepository() {
        this.values = new HashMap<>();
    }

    @Override
    public void save(Service service) {
        this.values.put(service.id().value(), service);
    }

    @Override
    public Optional<Service> findById(ServiceId id) {
        if (this.values.containsKey(id.value())) {
            return Optional.of(this.values.get(id.value()));
        }

        return Optional.empty();
    }

    @Override
    public Pagination<Service> match(ServiceCriteria criteria) {
        int skip = (criteria.page() - 1) * criteria.size();

        List<Service> paginationValues =  this.values.values()
                                                      .stream()
                                                      .skip(skip)
                                                      .filter(x -> x.mechanic().id().value().equals(criteria.userId()) || x.mechanic().garage().id().value().equals(criteria.userId()))
                                                      .limit(criteria.size())
                                                      .toList();

        return new Pagination<>(criteria.size(), criteria.page(), paginationValues);
    }

    @Override
    public List<Service> searchAll() {
        return this.values.values().stream().toList();
    }
}
