package ar.edu.ungs.carservicetracker.garages.domain;

import java.util.List;
import java.util.Optional;

public interface GarageRepository {
    void save(Garage garage);

    Optional<Garage> findById(GarageId id);

    List<Garage> searchAll();
}
