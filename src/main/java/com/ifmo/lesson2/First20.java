package com.ifmo.lesson2;

public class First20 {
    /*
     Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8
     16 32 64 128 ….
     */
    public static void main(String[] args) {
        // TODO implement
        int ntx = 2;
        for(int i = 0; i<20; i++)
        {
            int fib = ntx;
            System.out.print(fib + " ");

            ntx += fib;

        }
    }
}
