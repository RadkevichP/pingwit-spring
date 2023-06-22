package pl.pingwit.pingwitdemospring.lec_38;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitdemospring.lec_37.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pavel Radkevich
 * @since 22.06.23
 */
@Repository
public class UserRepository {

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

}