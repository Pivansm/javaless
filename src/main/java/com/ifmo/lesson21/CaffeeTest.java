package com.ifmo.lesson21;

public class CaffeeTest {
    public static Object object = new Object();

    public static void main(String[] args) {

        Order order = new Order("Dish");
        Client client = new Client(order);
        new Thread(client, "client1").start();

        //Client client2 = new Client(order);
        //new Thread(client, "client2").start();

        //Chef chef = new Chef(order);
        //new Thread(chef, "chef").start();

        //Waiter waiter = new Waiter(order);
        //new Thread(waiter, "waiter").start();

        System.out.println("Заказы все приняты!");
    }
}
