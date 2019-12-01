package com.ifmo.lesson21;

import java.util.*;

public class Client implements Runnable {
    private Order order;
    Waiter waiter;

    public Client(Order order) {
        this.order = order;
        waiter = new Waiter(order);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        new Thread(waiter, "waiter").start();
        System.out.println(name + " разбудили официанта!");

        synchronized (order) {
            try{
                System.out.println(name + " клиент спит ждем вызов официанта : " + System.currentTimeMillis());
                while (true) {
                    order.wait();
                    if (order.getFlagWaiter()) {
                        System.out.println("Заказ готов!");
                        break;
                    }
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " был вызов от официанта : " + System.currentTimeMillis());
            // обработаем наше сообщение
            System.out.println(name + " : получил заказ " + order.getBlude());
        }
    }
}
