package com.ifmo.lesson2;

import java.util.Arrays;

public class SquareEquation {
    /*
     В три переменные a, b и c записаны три вещественных числа. Создать программу, которая
     будет находить и выводить на экран вещественные корни квадратного уравнения ax²+bx+c=0,
     либо сообщать, что корней нет.
     */
    public static void main(String[] args) {
        double a = 2;
        double b = -9;
        double c = 9;

        double[] roots = squareEquationRoots(a, b, c);

        System.out.println(Arrays.toString(roots));
    }

    /*
    Возвращает массив из двух корней или null, если таковых нет.
     */
    public static double[] squareEquationRoots(double a, double b, double c) {
        // TODO implement
        double[] asru = new double[2];
        double d = Math.pow(b, 2) - 4*a*c;
        if (d > 0) {
            asru[0] = -b + Math.sqrt(d);
            asru[1] = -b - Math.sqrt(d);

        } else if (d == 0) {
            asru[0] = -b / 2 * a;
            asru[1] = 0.00;

        } else {
            System.out.println("Корней нет");
        }

        return asru;
    }
}
