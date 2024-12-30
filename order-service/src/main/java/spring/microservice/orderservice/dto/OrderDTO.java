package spring.microservice.orderservice.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderDTO {

    private Long id;
    private String orderNumber;
    private List<OrderLineItemsDTO> orderLineItems;

}
