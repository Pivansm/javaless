package com.ifmo.lesson5.snape;

public class Oval extends Shape {

    double x;
    double y;
    double radius;


    public Oval(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI*radius;
    }
}
