package com.ifmo.lesson5.snape;

public class Rectangle extends Shape {

    public double a;
    public double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public double area() {
        return a*b;
    }
}
