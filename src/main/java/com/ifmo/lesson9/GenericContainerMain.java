package com.ifmo.lesson9;

public class GenericContainerMain {
    public static void main(String[] args) {
        GenericContainer<String> container1 = new GenericContainer<String>("Some Value");
        GenericContainer<Integer> container2 = new GenericContainer<Integer>(null);
        String strVal = container1.getOrElse("Default value");
        Integer intVal = container2.getOrElse(0);
        System.out.println(strVal);
        System.out.println(intVal);
    }

}
