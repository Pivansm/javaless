package com.ifmo.lesson17;

public class JapanFactory extends Factory {

    public JapanFactory() {}

    @Override
    public Car create() {
        return new CarToyota();
    }
}
