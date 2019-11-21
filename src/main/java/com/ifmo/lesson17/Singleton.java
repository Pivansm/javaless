package com.ifmo.lesson17;

public class Singleton {
    private static final Singleton SINGL = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return SINGL;
    }

}
