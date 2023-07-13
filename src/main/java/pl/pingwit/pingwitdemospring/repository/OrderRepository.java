package pl.pingwit.pingwitdemospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pingwit.pingwitdemospring.repository.model.Order;

/**
 * @author Pavel Radkevich
 * @since 13.07.23
 */
@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
