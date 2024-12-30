package spring.microservice.productservice.service.implement;

import spring.microservice.productservice.dto.ProductDTO;
import spring.microservice.productservice.model.Product;
import spring.microservice.productservice.repository.ProductRepository;
import spring.microservice.productservice.service.ProductService;
import spring.microservice.productservice.utils.ModelMappingUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMappingUtil<Product, ProductDTO> modelMappingUtil;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        productRepository.save(product);
        log.info("Product {} is saved successfully", product.getId());
        return modelMappingUtil.mapToDTO(product, ProductDTO.class);
    }

    @Override
    public List<ProductDTO> getListOfProducts() {
        List<Product> products = productRepository.findAll();

        Product prod = new Product();
        prod.setName("Test");
        prod.setDescription("Test description");
        // List<Product> products2 = List.of(prod);

        List<ProductDTO> listResult = products.stream().map(
                p -> modelMappingUtil.mapToDTO(p, ProductDTO.class)).toList();
        log.info("List of products is {}", listResult);
        return listResult;
    }
}
