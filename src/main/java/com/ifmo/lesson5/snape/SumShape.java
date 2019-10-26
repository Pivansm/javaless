package com.ifmo.lesson5.snape;

import com.ifmo.lesson4.LinkedList;

public class SumShape {
    public static void main(String[] args) {
        double oSum = 0.0;
        /*LinkedList spSumm = new LinkedList();
        spSumm.add( new Circle(2.0));
        spSumm.add( new Oval(1,2,2.0));
        spSumm.add( new Rectangle(3, 4));
        spSumm.add( new Triangle(3,5,7));
        spSumm.add( new Square(4));*/
        oSum = sum(new Circle(2.0), new Oval(1,2,2.0));


        /*for(int i = 0; i<5; i++){
            Shape sp = (Shape)spSumm.get(i);
            System.out.println("Площадь фигуры:" + sp.area());
            oSum += sp.area();
        }*/

        System.out.print("Площадь" + oSum);

    }

    private static double sum(Shape ... shape) {
        double sum = 0;

        for(Shape sh : shape) {
            sum += sh.area();
        }

        return sum;
    }
}
