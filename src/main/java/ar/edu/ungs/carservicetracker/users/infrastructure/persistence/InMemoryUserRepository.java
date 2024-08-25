package ar.edu.ungs.carservicetracker.users.infrastructure.persistence;

import ar.edu.ungs.carservicetracker.users.domain.User;
import ar.edu.ungs.carservicetracker.users.domain.UserId;
import ar.edu.ungs.carservicetracker.users.domain.UserRepository;
import ar.edu.ungs.carservicetracker.users.domain.Username;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Component
public final class InMemoryUserRepository implements UserRepository {
    private final Map<String, User> values;

    public InMemoryUserRepository() {
        this.values = new HashMap<>();
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
}
