package ar.edu.ungs.carservicetracker.users.infrastructure.persistence;

import ar.edu.ungs.carservicetracker.garages.domain.Garage;
import ar.edu.ungs.carservicetracker.garages.domain.GarageId;
import ar.edu.ungs.carservicetracker.garages.domain.GarageName;
import ar.edu.ungs.carservicetracker.users.domain.*;
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
public final class PostgresUserRepository implements UserRepository, RowMapper<User> {
    private final JdbcTemplate jdbcTemplate;

    public PostgresUserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        if (user instanceof Admin) {
            var query = "insert into users (id, type, username, password) values (CAST(? as UUID), ?, ?, ?)";
            this.jdbcTemplate.update(query, user.id().value(), user.type().name(), user.username().value(), user.password().value());
        }

        if (user instanceof GarageUser) {
            var query = "insert into users (id, type, username, password, garage_id) values (CAST(? as UUID), ?, ?, ?, CAST(? as UUID))";
            this.jdbcTemplate.update(query, user.id().value(), user.type().name(), user.username().value(), user.password().value(), ((GarageUser) user).garage().id().value());
        }
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        try {
            var query = """
                select
                    u.id,
                    u.username,
                    u.type,
                    u.password,
                    u.garage_id,
                    g.name as garage_name
                from users u
                    left join garages g on u.garage_id = g.id
                where u.username = ?
            """;

            return Optional.ofNullable(
                    this.jdbcTemplate.queryForObject(query, this, username.value())
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<User> findById(UserId id) {
        try {
            var query = """
                select
                    u.id,
                    u.username,
                    u.type,
                    u.password,
                    u.garage_id,
                    g.name as garage_name
                from users u
                    left join garages g on u.garage_id = g.id
                where u.id = CAST(? as UUID)
            """;

            return Optional.ofNullable(
                    this.jdbcTemplate.queryForObject(query, this, id.value())
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> searchAll() {
        try {
            var query = """
                select
                    u.id,
                    u.username,
                    u.type,
                    u.password,
                    u.garage_id,
                    g.name as garage_name
                from users u
                    left join garages g on u.garage_id = g.id
            """;

            return this.jdbcTemplate.query(query, this);
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getString("id");
        var type = rs.getString("type");
        var username = rs.getString("username");
        var password = rs.getString("password");

        if (rs.getString("garage_id") != null) {
            var garageId = rs.getString("garage_id");
            var garageName = rs.getString("garage_name");
            Garage garage = Garage.create(garageId, garageName);

            return User.create(id, type, username, password, garage);
        }

        return User.create(id, type, username, password, null);
    }
}
