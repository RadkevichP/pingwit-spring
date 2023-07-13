package pl.pingwit.pingwitdemospring.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.pingwit.pingwitdemospring.controller.dto.OrderDto;
import pl.pingwit.pingwitdemospring.converter.OrderConverter;
import pl.pingwit.pingwitdemospring.exception.PingwitNotFoundException;
import pl.pingwit.pingwitdemospring.repository.OrderRepository;
import pl.pingwit.pingwitdemospring.repository.model.Order;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 13.07.23
 */
@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderConverter orderConverter;

    public OrderServiceImpl(OrderRepository orderRepository, OrderConverter orderConverter) {
        this.orderRepository = orderRepository;
        this.orderConverter = orderConverter;
    }


    @Override
    public List<OrderDto> getAll() {
        List<Order> all = orderRepository.findAll();
        return orderConverter.convertToDto(all);
    }

    @Override
    public Integer createOrder(OrderDto orderDto) {
        Order order = orderConverter.convertToEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return savedOrder.getId();
    }

    @Override
    public void deleteOrder(Integer orderId) {

    }

    @Override
    public OrderDto getById(Integer orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new PingwitNotFoundException("Order not found: " + orderId));
        return orderConverter.convertToDto(order);
    }
}
