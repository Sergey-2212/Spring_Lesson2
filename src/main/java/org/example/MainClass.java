package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class MainClass

{
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.example");
//        Box box = context.getBean(Box.class);
//        box.setColor("White");
//        System.out.println(box.getColor());

        OrderService orderService = context.getBean(OrderService.class);
        System.out.println("Welcome to our store");
        System.out.println("You can order:");
        orderService.printStorage();
        Scanner sc = new Scanner(System.in);
        String[] prs;
        while(true) {
            String command = sc.nextLine();
            prs = command.split(" ");
            if(prs[0].toLowerCase().contentEquals("add")) {
                orderService.addToCart(prs[1]);
            } else if (prs[0].toLowerCase().contentEquals("delete")) {
                orderService.deleteFromCart(prs[1]);
            } else if (prs[0].toLowerCase().contentEquals("print")) {
                orderService.printCart();
            } else if(prs[0].toLowerCase().contentEquals("exit")) {
                System.out.println("До скорой встречи!");
                context.close();
            }
        }
    }
}
