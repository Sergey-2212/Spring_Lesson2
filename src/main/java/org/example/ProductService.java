package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductService {


    // Не рекомендуется указывать @Autowired над ссылкой на объект, лучше через setter
    private ProductRepository storage;

    @Autowired
    public void setStorage(ProductRepository storage) {
        this.storage = storage;
    }

    public String getTitleByID(Long id) {
        return storage.findProductByID(id).getTitle();
    }

    public Product getProductByTitle(String title) throws ProductNotFoundException{
        return storage.findProductByTitle(title);
    }

    public void printStorageList() {
        for (Product s : storage.getAllProducts()) {
            System.out.println("Продукт - " + s.getTitle() + ". Цена - " + s.getCost() + ".");
        }
    }

}
