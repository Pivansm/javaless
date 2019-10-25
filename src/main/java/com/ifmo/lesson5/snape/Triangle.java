package com.ifmo.lesson5.snape;

public class Triangle extends Shape {

    double firstSide;
    double secondSide;
    double thirdSide;

    public Triangle(double firstSide, double secondSide, double thirdSide) {
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    public double getPerimeter() {
        return firstSide + secondSide + thirdSide;
    }

    @Override
    public double area() {
        double semiPerimeter = getPerimeter()/2;
        double buffer = semiPerimeter * (semiPerimeter - firstSide)
                * (semiPerimeter - secondSide)
                * (semiPerimeter - thirdSide);

        return Math.sqrt(buffer);
    }

}
