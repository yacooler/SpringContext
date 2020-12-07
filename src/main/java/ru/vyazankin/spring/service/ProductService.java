package ru.vyazankin.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vyazankin.spring.repository.ProductRepository;

@Component
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
