package ar.edu.ungs.carservicetracker.services.infrastructure.persistence;

import ar.edu.ungs.carservicetracker.customers.domain.Customer;
import ar.edu.ungs.carservicetracker.customers.domain.CustomerId;
import ar.edu.ungs.carservicetracker.customers.domain.services.DomainCustomerFinder;
import ar.edu.ungs.carservicetracker.services.domain.*;
import ar.edu.ungs.carservicetracker.shared.domain.Pagination;
import ar.edu.ungs.carservicetracker.users.domain.Mechanic;
import ar.edu.ungs.carservicetracker.users.domain.User;
import ar.edu.ungs.carservicetracker.users.domain.UserId;
import ar.edu.ungs.carservicetracker.users.domain.services.DomainUserFinder;
import ar.edu.ungs.carservicetracker.vehicles.domain.VehicleId;
import ar.edu.ungs.carservicetracker.vehicles.domain.services.DomainVehicleFinder;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Primary
@Component
public final class PostgresServiceRepository implements ServiceRepository, RowMapper<Service> {
    private final JdbcTemplate jdbcTemplate;
    private final DomainCustomerFinder customerFinder;
    private final DomainUserFinder userFinder;
    private final DomainVehicleFinder vehicleFinder;

    public PostgresServiceRepository(JdbcTemplate jdbcTemplate,
                                     DomainCustomerFinder customerFinder,
                                     DomainUserFinder userFinder,
                                     DomainVehicleFinder vehicleFinder) {
        this.jdbcTemplate = jdbcTemplate;
        this.customerFinder = customerFinder;
        this.userFinder = userFinder;
        this.vehicleFinder = vehicleFinder;
    }

    @Override
    public void save(Service service) {
        this.findById(service.id())
                .ifPresentOrElse(x -> {
                    var query = "UPDATE services SET mechanic_id = CAST(? as UUID), vehicle_id = CAST(? as UUID), customer_id = CAST(? as UUID), description = ?, status = ?, estimation_unit = ?, estimation_value = ?, costs_amount = ?, labor_amount = ? WHERE id = CAST(? as UUID)";
                    this.jdbcTemplate.update(query, service.mechanic().id().value(), service.vehicle().id().value(), service.customer().id().value(), service.description().value(), service.status().name(), service.estimation().unit().name(), service.estimation().value(), service.amount().costsAmount(), service.amount().laborAmount(), service.id().value());
                }, () -> {
                    var query = "INSERT INTO services (id, mechanic_id, vehicle_id, customer_id, description, status, estimation_unit, estimation_value, costs_amount, labor_amount) VALUES (CAST(? as UUID), CAST(? as UUID), CAST(? as UUID), CAST(? as UUID), ?, ?, ?, ?, ?, ?)";
                    this.jdbcTemplate.update(query, service.id().value(), service.mechanic().id().value(), service.vehicle().id().value(), service.customer().id().value(), service.description().value(), service.status().name(), service.estimation().unit().name(), service.estimation().value(), service.amount().costsAmount(), service.amount().laborAmount());
                });
    }

    @Override
    public Optional<Service> findById(ServiceId id) {
        try {
            var query = "select * from services where id = CAST(? as UUID)";
            return Optional.ofNullable(
                this.jdbcTemplate.queryForObject(query, this, id.value())
            );
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Pagination<Service> match(ServiceCriteria criteria) {
       return null;
    }

    @Override
    public List<Service> searchAll() {
        try {
            var query = "select * from services";
            return this.jdbcTemplate.query(query, this);
        } catch (EmptyResultDataAccessException e) {
            return List.of();
        }
    }

    @Override
    public Service mapRow(ResultSet rs, int rowNum) throws SQLException {
        var id = new ServiceId(rs.getString("id"));
        var customerId = rs.getString("customer_id");
        var mechanicId = rs.getString("mechanic_id");
        var vehicleId = rs.getString("vehicle_id");
        var description = new ServiceDescription(rs.getString("description"));
        var status = ServiceStatus.valueOf(rs.getString("status"));
        var estimationUnit = ServiceEstimationUnit.valueOf(rs.getString("estimation_unit"));
        var estimationValue = rs.getInt("estimation_value");
        var estimation = new ServiceEstimation(estimationUnit, estimationValue);
        var costsAmount = rs.getBigDecimal("costs_amount");
        var laborAmount = rs.getBigDecimal("labor_amount");
        var amount = new ServiceAmount(costsAmount, laborAmount);
        var mechanic = (Mechanic) this.userFinder.execute(new UserId(mechanicId));
        var customer = this.customerFinder.execute(new CustomerId(customerId));
        var vehicle = this.vehicleFinder.execute(new VehicleId(vehicleId));

        return new Service(id, status, description, estimation, amount, mechanic, vehicle, customer);
    }
}
