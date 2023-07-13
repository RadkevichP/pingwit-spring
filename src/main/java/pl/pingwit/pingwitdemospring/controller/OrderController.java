package pl.pingwit.pingwitdemospring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.pingwit.pingwitdemospring.controller.dto.OrderDto;
import pl.pingwit.pingwitdemospring.service.OrderService;

import java.util.List;

/**
 * @author Pavel Radkevich
 * @since 13.07.23
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderDto> getAllOrders() {
        return orderService.getAll();
    }

    @PostMapping
    public Integer createOrder(@RequestBody OrderDto orderDto) {
        return orderService.createOrder(orderDto);
    }

    @GetMapping("/{id}")
    public OrderDto getById(@PathVariable Integer id) {
        logger.trace(String.format("requsted order# %s", id));
        return orderService.getById(id);
    }
}
