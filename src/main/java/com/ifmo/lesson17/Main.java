package com.ifmo.lesson17;

import java.io.Console;

public class Main {
    public static void main(String[] args) {

        Factory factory = Factory.getFactory("JP");
        Car car = factory.create();
        System.out.println("" + car);

    }
}
