package pl.pingwit.pingwitdemospring.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import pl.pingwit.pingwitdemospring.repository.model.User;

/**
 * @author Pavel Radkevich
 * @since 10.07.23
 */
public interface PagingUserRepository extends PagingAndSortingRepository<User, Integer> {
}
