package pl.pingwit.pingwitdemospring.repository;

import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.Collection;
import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 29.06.23
 */
public interface UserRepository {

    User getById(Integer id);

    Collection<User> getAll();

    void delete(Integer userId);

    Integer createUser(User userToCreate);

    List<User> searchByName(String name);
}
