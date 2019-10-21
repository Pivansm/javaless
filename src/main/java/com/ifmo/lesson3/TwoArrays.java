package com.ifmo.lesson3;

import java.util.Random;

public class TwoArrays {
    /*
     Создайте 2 массива из 5 случайных целых чисел из отрезка [0;5] каждый, выведите
     массивы на экран в двух отдельных строках. Посчитайте среднее арифметическое элементов
     каждого массива и сообщите, для какого из массивов это значение оказалось больше (либо
     сообщите, что их средние арифметические равны).
     */
    public static void main(String[] args) {
        int[] randomNumbers1 = randomNumbers();
        System.out.print("\n");
        int[] randomNumbers2 = randomNumbers();

        // TODO implement

        int average1 = average(randomNumbers1);
        System.out.print("\n" + average1);
        int average2 = average(randomNumbers2);
        System.out.print("\n" + average2);
        if(average1 > average2)
            System.out.print("\nсреднее арифметическое массива randomNumbers1 больше чем массива randomNumbers2");
        if(average1 < average2)
            System.out.print("\nсреднее арифметическое массива randomNumbers2 больше чем массива randomNumbers1");
        if(average1 == average2)
            System.out.print("\nсреднее арифметическое массива randomNumbers1 равно среднее арифметическому массива randomNumbers2");

        // TODO implement
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[5];
        Random ran = new Random();

        for(int i = 0; i<5; i++)
        {
            r[i] = ran.nextInt(5);
            System.out.print(r[i] + " ");
        }
        return r;

    }

    public static int average(int[] randomNumbers) {
        // TODO implement
        int su = 0;
        for(int i : randomNumbers)
        {
            su+= i;
        }
        return su/randomNumbers.length;
    }
}
