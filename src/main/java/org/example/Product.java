package org.example;

import jdk.jfr.DataAmount;
import lombok.Data;
import org.springframework.stereotype.Component;


@Data
public class Product {

    private Long id;
    private String title;
    private double cost;

    public Product(Long id, String title, double cost) {
        this.id = id;
        this.title = title;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Продукт - " + title + ". Цена - " + cost;
    }
}
