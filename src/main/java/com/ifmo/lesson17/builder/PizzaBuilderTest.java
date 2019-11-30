package com.ifmo.lesson17.builder;

public class PizzaBuilderTest {
    public static void main(String[] args) {

        Pizza cheese = new Pizza
                .Builder()
                .cheese("Cheese")
                .tomatoes(10)
                .pepperoni(5)
                .build();

        System.out.println(cheese);
     }
}
