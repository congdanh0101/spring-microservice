package spring.microservice.productservice.service;

import spring.microservice.productservice.dto.ProductDTO;
import spring.microservice.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public ProductDTO createProduct(ProductDTO productDTO);

    public List<ProductDTO> getListOfProducts();
}
