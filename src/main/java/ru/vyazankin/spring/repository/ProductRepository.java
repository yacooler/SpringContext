package ru.vyazankin.spring.repository;

import org.springframework.stereotype.Component;
import ru.vyazankin.spring.entity.Product;

import java.util.List;

@Component
public interface ProductRepository {
    public List<Product> getProducts();
}
