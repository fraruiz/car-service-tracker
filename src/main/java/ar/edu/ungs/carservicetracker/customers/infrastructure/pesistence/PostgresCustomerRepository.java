package ar.edu.ungs.carservicetracker.customers.infrastructure.pesistence;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerRepository;
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
public final class PostgresCustomerRepository implements CustomerRepository, RowMapper<Customer> {
    private final JdbcTemplate jdbcTemplate;

    public PostgresCustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Customer customer) {
        var query = "insert into customers (id, fullname, email) values (CAST(? as UUID), ?, ?)";
        this.jdbcTemplate.update(query, customer.id().value(), customer.fullName().value(), customer.email().value());
    }

    @Override
    public Optional<Customer> findById(CustomerId id) {
        try {
            var query = "select id, fullname, email from customers where id = CAST(? as UUID)";
            return Optional.ofNullable(jdbcTemplate.queryForObject(query, this, id.value()));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Customer> searchAll() {
        try {
            var query = "select id, fullname, email from customers";
            return jdbcTemplate.query(query, this);
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = rs.getString("id");
        var fullname = rs.getString("fullname");
        var email = rs.getString("email");

        return Customer.create(id, fullname, email);
    }
}
