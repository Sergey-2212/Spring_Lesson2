package org.example;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class ProductRepository {

    private List<Product> products;

    @PostConstruct // метод обозначенный PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1L, "Bread", 31.50),
                new Product(2L, "Butter", 210.50),
                new Product(3L, "Milk", 95.20),
                new Product(4L, "Crisps", 67.99),
                new Product(5L, "Ham", 599.99)

        ));
    }

    public Product findProductByID(Long id) {
        for (Product s: products) {
            if(s.getId().equals(id)) {
                return s;
            }
        }
        throw new RuntimeException();
    }

    public Product findProductByTitle(String title) throws ProductNotFoundException{
        for (Product s: products) {
            if(s.getTitle().equals(title)) {
                return s;
            }
        }
        throw new ProductNotFoundException();
    }



    public List<Product> getAllProducts() {
        return products;
    }

}
