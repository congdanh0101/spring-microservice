package spring.microservice.orderservice.service;

import spring.microservice.orderservice.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    public OrderDTO placeOrder(OrderDTO orderDTO);

    public List<OrderDTO> getAllOrders();
}
