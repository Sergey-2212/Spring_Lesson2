package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Component
public class CartService {
    //Аннотация @Autowired над ссылкой к объекту говорит спрингу о необходимости прикрепить к этой ссылке объект из контекста, т.е. инициализирует его.
    //НО не рекомендуется указывать непосредственно на ссылкой, лучше через Setter
    private Cart cart;

    @Autowired
    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void addProduct(Product product) {
        cart.addProductToCart(product);
        System.out.println(product.getTitle() + " добавлен в корзину.");
    }

    public void deleteProduct(Product product) {
        if(cart.deleteProductFromCart(product)) {
            System.out.println("Продукт - " + product.getTitle() + " удален из корзины.");
        } else {
            System.out.println("Продукта - " + product.getTitle() + " нет в корзине");
        }
    }

    public void printCart() {
        if(cart.getCart().isEmpty()){
            System.out.println("Корзина пуста.");
        }
        for (Product s: cart.getCart()) {
            System.out.println(s.toString());
        }
    }
}
