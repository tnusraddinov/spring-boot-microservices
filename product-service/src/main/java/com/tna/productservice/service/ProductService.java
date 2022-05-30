package com.tna.productservice.service;

import com.tna.productservice.dto.CreateProductRequest;
import com.tna.productservice.dto.ProductDto;
import com.tna.productservice.model.Product;
import com.tna.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(CreateProductRequest request){
        Product product = new Product()
                .setName(request.name())
                .setDescription(request.description())
                .setPrice(request.price());
        product = productRepository.save(product);
        log.debug("product {} saved", product);
    }

    public List<ProductDto> getProducts() {
        return productRepository.findAll().stream().map(ProductDto::of).toList();
    }
}
