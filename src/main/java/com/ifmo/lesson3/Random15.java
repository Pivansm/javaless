package com.ifmo.lesson3;

import java.util.Random;

public class Random15 {
    /*
     Создайте массив из 15 случайных целых чисел из отрезка [0;9]. Выведите массив на экран.
     Подсчитайте сколько в массиве чётных элементов и выведете это количество на экран на
     отдельной строке.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement

        int evens = evens(randomNumbers);
        System.out.print("\n" + evens);
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[15];
        Random ran = new Random();

        for(int i = 0; i<15; i++)
        {
            r[i] = ran.nextInt(9);
            System.out.print(r[i] + " ");
        }
        return r;
    }

    private static int evens(int[] arr) {
        // TODO implement
        int c=0;
        for(int i = 0; i<arr.length; i++)
        {
            //System.out.print(arr[i] + " ");
            if((arr[i])%2 == 0)
            {
                c++;
                //System.out.print(arr[i] + " ");
            }

        }
        return c;
    }
}
