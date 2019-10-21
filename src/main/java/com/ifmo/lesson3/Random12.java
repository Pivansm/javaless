package com.ifmo.lesson3;

import java.util.Arrays;
import java.util.Random;

public class Random12 {
    /*
    Создайте массив из 12 случайных целых чисел из отрезка [-15;15]. Определите какой
    элемент является в этом массиве максимальным и сообщите индекс его последнего
    вхождения в массив.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement

        int max = max(randomNumbers);
        int maxLastIndex = lastIndexOf(randomNumbers, max);
        System.out.print("\n"+maxLastIndex);
        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[12];
        Random ran = new Random();

        for(int i = 0; i<12; i++)
        {
            r[i] = ran.nextInt(30) -15;
            System.out.print(r[i] + " ");
        }
        return r;
    }

    public static int max(int[] randomNumbers) {
        // TODO implement
        int m = randomNumbers[0];

        for (int i = 0; i < randomNumbers.length; i++)
            if (m < randomNumbers[i]) m = randomNumbers[i];

        return m;
    }

    public static int lastIndexOf(int[] randomNumbers, int max) {
        // TODO implement
        int u = 0;
        for(int i = 0; i<randomNumbers.length; i++)
        {
            if(randomNumbers[i] == max)
            {
                u = i;
            }
        }
        return u;
    }
}
