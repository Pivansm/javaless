package com.ifmo.lesson3;

public class EvenArray {
    /*
    Создайте массив из всех чётных чисел от 2 до 20 и выведите элементы массива на экран
    сначала в строку, отделяя один элемент от другого пробелом, а затем в столбик (отделяя один
    элемент от другого началом новой строки). Перед созданием массива подумайте, какого он
    будет размера.2 4 6 … 18 20246…20
     */
    public static void main(String[] args) {
        int[] evenArray = evenArray();

        // TODO implement
        for(int i : evenArray)
        {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        for(int i : evenArray)
        {
            System.out.println(i + "");
        }

    }

    public static int[] evenArray() {
        // TODO implement
        int[] imas = new int[10];
        int d = 0;
        for(int i = 0; i<10; i++)
        {
            d+=2;
            imas[i] = d;
        }
        return imas;
    }
}
