package spring.microservice.orderservice.service.implement;

import spring.microservice.orderservice.dto.OrderDTO;
import spring.microservice.orderservice.dto.OrderLineItemsDTO;
import spring.microservice.orderservice.model.Order;
import spring.microservice.orderservice.model.OrderLineItems;
import spring.microservice.orderservice.repository.OrderRepository;
import spring.microservice.orderservice.service.OrderService;
import spring.microservice.orderservice.utils.ModelMappingUtil;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ModelMappingUtil<Order, OrderDTO> modelMappingUtilOrder;

    @Autowired
    private ModelMappingUtil<OrderLineItems, OrderLineItemsDTO> modelMappingUtilOrderLineItems;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderDTO placeOrder(OrderDTO orderDTO) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> listOrderLineItems = orderDTO.getOrderLineItems()
                .stream()
                .map(o -> modelMappingUtilOrderLineItems.mapToEntity(o,OrderLineItems.class))
                .toList();
        order.setOrderLineItems(listOrderLineItems);    

        orderRepository.save(order);

        log.info("Order {} was placed successfully", order.getId());

        return modelMappingUtilOrder.mapToDTO(order, OrderDTO.class);
    }

    @Override
    public List<OrderDTO> getAllOrders() {

        List<OrderDTO> listOrders =  orderRepository.findAll()
                .stream()
                .map(o -> modelMappingUtilOrder.mapToDTO(o,OrderDTO.class))
                .toList();



        return listOrders;
    }

}
