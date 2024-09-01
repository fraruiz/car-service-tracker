package ar.edu.ungs.carservicetracker.garages.infrastructure.pesistence;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageId;
import ar.edu.ungs.carservicetracker.garages.domain.GarageRepository;
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
public final class PostgresGarageRepository implements GarageRepository, RowMapper<Garage> {
    private final JdbcTemplate jdbcTemplate;

    public PostgresGarageRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Garage garage) {
        var query = "insert into garages (id, name) values (CAST(? as UUID), ?)";
        this.jdbcTemplate.update(query, garage.id().value(), garage.name().value());
    }

    @Override
    public Optional<Garage> findById(GarageId id) {
        try {
            var query = "select id, name from garages where id = CAST(? as UUID)";
            return Optional.ofNullable(
                this.jdbcTemplate.queryForObject(query, this, id.value())
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Garage> searchAll() {
        try {
            var query = "select id, name from garages";
            return this.jdbcTemplate.query(query, this);
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public Garage mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getString("id");
        var name = rs.getString("name");

        return Garage.create(id, name);
    }
}
