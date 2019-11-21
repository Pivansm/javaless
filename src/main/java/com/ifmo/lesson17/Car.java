package com.ifmo.lesson17;

public class Car implements Creator {

    public Car() {}

    @Override
    public Car factoryMetod() {
        return new Car();
    }
}
