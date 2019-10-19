package com.ifmo.lesson3;

public class Fibonacci20 {
    /*
    Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран. Напоминаем,
    что первый и второй члены последовательности равны единицам, а каждый следующий —
    сумме двух предыдущих.
     */
    public static void main(String[] args) {
        int[] fibonacciNumbers = fibonacciNumbers();

        // TODO implement
        for(int i : fibonacciNumbers)
            System.out.print(i + " ");
    }

    public static int[] fibonacciNumbers() {
        // TODO implement
        int[] f = new int[20];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i<20; i++)
        {
            f[i] = f[i-2] + f[i-1];
        }
        return f;
    }

}
