package ar.edu.ungs.carservicetracker.users.domain;


import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);

    Optional<User> findByUsername(Username username);

    Optional<User> findById(UserId id);

    List<User> searchAll();
}
