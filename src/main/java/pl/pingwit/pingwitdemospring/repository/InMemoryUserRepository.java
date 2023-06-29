package pl.pingwit.pingwitdemospring.repository;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
//@Repository
public class InMemoryUserRepository implements UserRepository {

    private Map<Integer, User> users = new HashMap<>();

    @PostConstruct
    public void init() {
        users.put(1, new User(1, "Pavel", "Radkevich", "88", "888"));
        users.put(2, new User(2, "Alex", "Terner", "88", "888"));
        users.put(3, new User(3, "Vova", "Pova", "88", "888"));
    }


    public User getById(Integer id) {
        return users.get(id);
    }

    public Collection<User> getAll() {
        return users.values();
    }

    public void delete(Integer userId) {
        users.remove(userId);
    }

    public Integer createUser(User userToCreate) {
        users.put(userToCreate.id(), userToCreate);
        return userToCreate.id();
    }
}
