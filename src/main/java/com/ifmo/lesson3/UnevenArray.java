package com.ifmo.lesson3;

public class UnevenArray {
    /*
    Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку, а затем
    этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3
    1)
     */
    public static void main(String[] args) {
        int[] unevenArray = unevenArray();
        for(int i = 0; i<unevenArray.length; i++)
        {
            System.out.print(unevenArray[i] + " ");
        }
        // TODO implement
        System.out.print("\n");
        int j = 49;
        while(j > -1) {
            System.out.print(unevenArray[j] + " ");
            j--;
        }
    }

    public static int[] unevenArray() {
        // TODO implement
        int[] imas = new int[50];
        int d = 1;
        for(int i = 0; i<50; i++)
        {
            imas[i] = d;
            d+=2;
        }
        return imas;

    }
}
