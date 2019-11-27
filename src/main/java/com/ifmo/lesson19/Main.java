package com.ifmo.lesson19;

public class Main {
    public static void main(String[] args) {
        Abeant a = new Abeant();

        ReflectionUtils reflectionUtils = new ReflectionUtils();
        System.out.println(reflectionUtils.toString(a));
    }
}
