package spring.microservice.inventoryservice.dto;

import lombok.Data;

@Data
public class InventoryDTO {
    private Long id;
    private String skuCode;
    private Integer quantity;
}
