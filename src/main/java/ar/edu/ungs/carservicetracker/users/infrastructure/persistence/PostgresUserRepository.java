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
        var query = "insert into users (id, type, username, password, garage_id) values (?, ?, ?, ?, ?)";
        this.jdbcTemplate.update(query, user.id().value(), user.type().name(), user.username().value(), user.password().value());
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
                    g.name
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
                    g.name
                from users u
                    left join garages g on u.garage_id = g.id
                where u.id = ?
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
                    g.name
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
        UserId id = new UserId(rs.getString("id"));
        UserType type = UserType.valueOf(rs.getString("type"));
        Username username = new Username(rs.getString("username"));
        Password password = new Password(rs.getString("password"));

        if (type.equals(UserType.ADMIN)) {
            return new Admin(id, username, password);
        }

        GarageId garageId = new GarageId(rs.getString("garage_id"));
        GarageName garageName = new GarageName(rs.getString("g.name"));
        Garage garage = new Garage(garageId, garageName);

        if (type.equals(UserType.GARAGE_ADMIN)) {
            return new GarageAdmin(id, username, password, garage);
        } else {
            return new Mechanic(id, username, password, garage);
        }
    }
}
