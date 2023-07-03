package pl.pingwit.pingwitdemospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitdemospring.repository.model.User;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 3.07.23
 */
@Repository
public interface SpringDataUserRepository extends JpaRepository<User, Integer> {

    List<User> findAllByNameOrderBySurname(String name);

    List<User> findAllByNameAndSurname(String name, String surname);
}
