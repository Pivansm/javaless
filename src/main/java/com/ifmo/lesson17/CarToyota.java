package com.ifmo.lesson17;

public class CarToyota extends Car {
    private int power;
    private int maxspeed;

    public CarToyota() {
        this.power = 150;
        this.maxspeed = 200;
    }

    public int power() {
        return power;
    }

    public int maxSpeed() {
        return maxspeed;
    }
}
