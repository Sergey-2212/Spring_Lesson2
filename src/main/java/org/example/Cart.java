package org.example;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Priority;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {

    private List<Product> productList = new ArrayList<>();

    public void addProductToCart(Product product){
        productList.add(product);
    }

    public boolean deleteProductFromCart(Product product) {
        try {
           return productList.remove(product);
        } catch (Exception e) {
            return false;
        }
    }

    public List<Product> getCart() {
        return productList;
    }
}
