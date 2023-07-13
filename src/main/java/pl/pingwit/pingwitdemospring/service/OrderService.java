package pl.pingwit.pingwitdemospring.service;

import pl.pingwit.pingwitdemospring.controller.dto.OrderDto;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 13.07.23
 */
public interface OrderService {

    List<OrderDto> getAll();

    Integer createOrder(OrderDto orderDto);

    void deleteOrder(Integer orderId);

    OrderDto getById(Integer orderId);
}
