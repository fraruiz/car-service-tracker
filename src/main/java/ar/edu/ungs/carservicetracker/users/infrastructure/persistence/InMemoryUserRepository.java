package ar.edu.ungs.carservicetracker.users.infrastructure.persistence;

import ar.edu.ungs.carservicetracker.users.domain.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public final class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> values;

    public InMemoryUserRepository() {
        this.values = new HashMap<>();

        this.values.put("admin", new Admin(new UserId(UUID.randomUUID().toString()), new Username("admin"), new Password("admin")));
    }

    @Override
    public void save(User user) {
        this.values.put(user.username().value(), user);
    }

    @Override
    public Optional<User> findByUsername(Username username) {
        if (this.values.containsKey(username.value())){
            return Optional.of(this.values.get(username.value()));
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(UserId id) {
        return this.values.values()
                          .stream()
                          .filter(x -> x.id().value().equals(id.value()))
                          .findAny();
    }

    @Override
    public List<User> searchAll() {
        return this.values.values().stream().toList();
    }
}
