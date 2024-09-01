package ar.edu.ungs.carservicetracker.vehicles.infrastructure.pesistence;

import ar.edu.ungs.carservicetracker.vehicles.domain.*;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Primary
@Component
public final class PostgresVehicleRepository implements VehicleRepository, RowMapper<Vehicle> {
    private final JdbcTemplate jdbcTemplate;

    public PostgresVehicleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Vehicle vehicle) {
        var query = "insert into vehicles (id, model, brand) values (CAST(? as UUID), ?, ?)";
        this.jdbcTemplate.update(query, vehicle.id().value(), vehicle.model().value(), vehicle.brand().value());
    }

    @Override
    public Optional<Vehicle> findById(VehicleId id) {
        try {
            var query = """
                select
                    id,
                    model,
                    brand
                from vehicles v
                where v.id = CAST(? as UUID)
            """;

            return Optional.ofNullable(
                    this.jdbcTemplate.queryForObject(query, this, id.value())
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Vehicle> searchAll() {
        try {
            var query = """
                select
                    id,
                    model,
                    brand
                from vehicles v
            """;

            return this.jdbcTemplate.query(query, this);
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getString("id");
        var brand = rs.getString("brand");
        var model = rs.getString("model");

        return Vehicle.create(id, brand, model);
    }
}
