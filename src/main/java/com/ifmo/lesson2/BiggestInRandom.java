package com.ifmo.lesson2;

import java.util.Random;

public class BiggestInRandom {
    /*
     Создать программу, выводящую на экран случайно сгенерированное трёхзначное
     натуральное число и его наибольшую цифру.Примеры работы программы:
     В числе 208 наибольшая цифра 8.
     В числе 774 наибольшая цифра 7.
     В числе 613 наибольшая цифра 6.
     */
    public static void main(String[] args) {
        int rnd = threeDigitRandom();

        String largestDigit = largestDigit(rnd);

        System.out.println(largestDigit);
    }

    public static int threeDigitRandom() {
        // TODO implement
        Random ran = new Random();

        int i = ran.nextInt(900) + 100;
        return i;
    }

    public static String largestDigit(int rnd) {
        // TODO implement

        int max = 0;
        int n = rnd;
        while(n != 0) {

            if(max < n%10)
                max = n%10;

            n /=10;
        }

        return "В числе " + rnd + " наибольшая цифра " + max + ".";
    }
}
