package ar.edu.ungs.carservicetracker.garages.infrastructure.pesistence;


import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryGarageRepository implements GarageRepository {
    private final Map<Long, Garage> values;

    public InMemoryGarageRepository() {
        this.values = new HashMap<>();
    }


    @Override
    public void save(Garage Garage) {

        Long GarageId = Long.parseLong(Garage.id().value());

        this.values.put(GarageId, Garage); //Me tira error porque pide un long


    }

    @Override
    public Optional<Garage> findById(Long id) {

        if (this.values.containsKey(id)) {
            return Optional.of(this.values.get(id));
        }

        return Optional.empty();
    }


    @Override
    public List<Garage> searchAll() {
        return this.values.values().stream().toList();
    }
}
