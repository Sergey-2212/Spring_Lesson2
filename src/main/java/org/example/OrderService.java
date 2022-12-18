package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    private CartService cartService;
    private ProductService productService;

    @Autowired
    public void setCartService(CartService cartService) {
        this.cartService = cartService;
    }
    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    public void addToCart(String pr) {
        Product product = null;
        try {
            product = productService.getProductByTitle(pr);
        } catch (ProductNotFoundException e) {
            System.out.println("Продукта нет в магазине.");
        }
        cartService.addProduct(product);
    }

    public void deleteFromCart(String pr) {
        Product product = null;
        try {
            product = productService.getProductByTitle(pr);
        } catch (ProductNotFoundException e) {
            System.out.println("Продукта нет в магазине.");
        }
        cartService.deleteProduct(product);
    }

    public void printStorage() {
        productService.printStorageList();
    }

    public void printCart() {
        cartService.printCart();
    }

}
