package com.ifmo.lesson2;

public class Fibonacci {
    /*
     Выведите на экран первые 11 членов последовательности Фибоначчи. Напоминаем, что
     первый и второй члены последовательности равны единицам, а каждый следующий — сумме
     двух предыдущих.
     */
    public static void main(String[] args) {
        // TODO implement
        int nxt = 1;
        int nxt2 = 1;

        System.out.print(nxt + " " + nxt + " ");
        for(int i = 3; i<12; i++)
        {
            int fib = nxt + nxt2;
            System.out.print(fib + " ");

            nxt = nxt2;
            nxt2 = fib;

        }
    }
}
