package com.ifmo.lesson5.snape;

public class Square extends Rectangle {

    public Square(double a) {
        super(a, a);
    }

    @Override
    public double area() {
        return Math.pow(a, 2);
    }

}
