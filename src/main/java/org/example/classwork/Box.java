package org.example.classwork;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype") //может быть "singleton", "prototypr", "session"
public class Box {

    private String color;

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public Box(String color) {
        this.color = color;
    }
    //спринг не использует конструкторы класса для инициализации бина
    public Box() {
    }

    //Если нужно инициализировать параметры класса значениями, можно создать инициализирующий метод и пометить его аннотацтей
    //после создания Бина такой метод отработает и выполнит необходимые конфигурирующие действия.
    @PostConstruct
    public void init() {
        color = "Red";

    }
}
