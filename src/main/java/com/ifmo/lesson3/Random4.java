package com.ifmo.lesson3;

import java.util.Random;

public class Random4 {
    /*
    Создайте массив из 4 случайных целых чисел из отрезка [10;99], выведите его на экран в
    строку. Определить и вывести на экран сообщение о том, является ли массив строго
    возрастающей последовательностью.
     */
    public static void main(String[] args) {
        int[] randomNumbers = randomNumbers();

        // TODO implement
        if(isIncreasingSequence(randomNumbers))
            System.out.println("массив является строго возрастающей последовательностью");
        else
            System.out.println("массив неявляется строго возрастающей последовательностью");
    }

    public static int[] randomNumbers() {
        // TODO implement
        int[] r = new int[4];
        Random ran = new Random();

        for(int i = 0; i<4; i++)
        {
            r[i] = ran.nextInt(89) + 10;
            System.out.print(r[i] + " ");
        }
        return r;
    }

    public static boolean isIncreasingSequence(int[] randomNumbers) {
        // TODO implement
        for(int i = 1; i<4; i++)
        {
            if(randomNumbers[i-1] > randomNumbers[i])
                return false;
        }
        return true;
    }
}
