package com.ifmo.lesson3;

import java.util.Random;

public class Random8 {
    /*
    Создайте массив из 8 случайных целых чисел из отрезка [1;10]. Выведите массив на экран
    в строку. Замените каждый элемент с нечётным индексом на ноль. Снова выведете массив на
    экран на отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        System.out.print("\n");
        int[] replacedWithZeros = replaceWithZeros(randomNumbers);



        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[8];
        Random ran = new Random();

        for(int i = 0; i<8; i++)
        {
            r[i] = ran.nextInt(9) + 1;
            System.out.print(r[i] + " ");
        }
        return r;

    }

    public static int[] replaceWithZeros(int[] randomNumbers) {
        // TODO implement
        int[] g = randomNumbers.clone();
        for(int i = 0; i<g.length; i++) {
            if((i)%2 > 0 )
                g[i] = 0;
            System.out.print(g[i] + " ");
        }

        return g;
    }
}
