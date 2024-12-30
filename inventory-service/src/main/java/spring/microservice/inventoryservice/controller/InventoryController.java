package spring.microservice.inventoryservice.controller;


import spring.microservice.inventoryservice.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@Slf4j
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/{skuCode}")
    public ResponseEntity<?> isInStock(@PathVariable String skuCode){
        return new ResponseEntity<>(inventoryService.isInStock(skuCode), HttpStatus.OK);
    }

}
