package spring.microservice.productservice.controller;


import spring.microservice.productservice.dto.ProductDTO;
import spring.microservice.productservice.model.Product;
import spring.microservice.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(productService.createProduct(productDTO),HttpStatus.CREATED);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductDTO> getListOfProducts() {
        return productService.getListOfProducts();
    }
}
