package ru.vyazankin.spring.repository;

import org.springframework.stereotype.Component;
import ru.vyazankin.spring.entity.Product;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;


@Component
public class ProductMockRepository implements ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void initList(){
        products.add(new Product());
    }

    @Override
    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
