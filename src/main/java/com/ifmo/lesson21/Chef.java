package com.ifmo.lesson21;

import java.util.*;

public class Chef implements Runnable {
    Order order;

    public Chef(Order order) {
        this.order = order;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        try {
            Thread.sleep(500);
            synchronized (CaffeeTest.object) {
                order.setFlagChef(true);
                System.out.println("Блюдо от шефа готово!");
                CaffeeTest.object.notify();
            }

         } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
