package com.ifmo.lesson1;

public class TwoDigitsSum {
    /*
    В переменной n хранится натуральное двузначное число.
    Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
     */
    public static void main(String[] args) {
        int n = 23;

        int sum = sum(n);

        System.out.println(sum);
    }

    public static int sum(int n) {
        // TODO implement
        int su = 0;
        while(n != 0) {
           su += n%10;
           n /=10;
        }

        return su;
    }
}
