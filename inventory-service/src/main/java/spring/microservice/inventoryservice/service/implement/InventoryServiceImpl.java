package spring.microservice.inventoryservice.service.implement;

import spring.microservice.inventoryservice.repository.InventoryRepository;
import spring.microservice.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Override
    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode) {
        return  inventoryRepository.findBySkuCode(skuCode).isPresent();

    }
}
