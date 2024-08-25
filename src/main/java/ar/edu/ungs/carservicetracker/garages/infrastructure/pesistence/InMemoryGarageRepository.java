package ar.edu.ungs.carservicetracker.garages.infrastructure.pesistence;


import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageId;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryGarageRepository implements GarageRepository {
    private final Map<String, Garage> values;

    public InMemoryGarageRepository() {
        this.values = new HashMap<>();
    }


    @Override
    public void save(Garage garage) {
        this.values.put(garage.id().value(), garage);
    }

    @Override
    public Optional<Garage> findById(GarageId id) {

        if (this.values.containsKey(id.value())) {
            return Optional.of(this.values.get(id.value()));
        }

        return Optional.empty();
    }


    @Override
    public List<Garage> searchAll() {
        return this.values.values().stream().toList();
    }
}
