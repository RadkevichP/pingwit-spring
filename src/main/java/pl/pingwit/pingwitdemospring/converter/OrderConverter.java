package pl.pingwit.pingwitdemospring.converter;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.pingwit.pingwitdemospring.controller.dto.OrderDto;
import pl.pingwit.pingwitdemospring.repository.model.Order;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 13.07.23
 */
@Component
public class OrderConverter {

    private static final Logger logger = LoggerFactory.getLogger(OrderConverter.class);

    private final UserConverter userConverter;
    private final OrderItemConverter orderItemConverter;

    public OrderConverter(UserConverter userConverter, OrderItemConverter orderItemConverter) {
        this.userConverter = userConverter;
        this.orderItemConverter = orderItemConverter;
    }

    public OrderDto convertToDto(Order order) {
        return convert(order);
    }

    public List<OrderDto> convertToDto(List<Order> all) {
        return all.stream()
                .map(this::convert)
                .toList();
    }

    public Order convertToEntity(OrderDto source) {
        Order result = new Order();
        result.setUser(userConverter.convertToEntity(source.getUser()));
        result.setOrderItems(orderItemConverter.convertToEntity(source.getOrderItems(), result));
        result.setCreatedAt(source.getCreatedAt());
        result.setComment(source.getComment());
        return result;
    }

    private OrderDto convert(Order source) {
        OrderDto target = new OrderDto();
        target.setId(source.getId());
        target.setCreatedAt(source.getCreatedAt());
        target.setUser(userConverter.convertToDto(source.getUser()));
        logger.debug("сейчас будем качать строчки заказа!------------------");
        target.setOrderItems(orderItemConverter.convertToDto(source.getOrderItems()));
        target.setComment(source.getComment());
        return target;
    }
}
