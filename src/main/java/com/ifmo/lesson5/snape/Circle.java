package com.ifmo.lesson5.snape;

public class Circle extends Oval{

      public Circle(double r) {

         super(0,0, r);
    }

    @Override
    public double area() {

          return Math.PI*radius*radius;
    }


}
