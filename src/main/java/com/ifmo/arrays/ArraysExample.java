package com.itmo.arrays;

import java.util.Arrays;

/**
 * Created by xmitya on 18.09.16.
 */
public class ArraysExample {
    public static void main(String[] args) {
        arrayCreation();
        arrayCopy();
        accessArrayElements();
        arrayComparison();
        operations();
    }

    public static void arrayCreation() {
        // Объявляем и создаем массив типа int на 10 элементов.
        // Массивы - объекты, поэтому они могут быть созданы при помощи ключевого слова new.
        int[] intArr1 = new int[10];

        // Массив всегда инициализируется со значениями по умолчанию.
        // Для чисел это всегда 0.
        System.out.println(Arrays.toString(intArr1)); // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

        // Массив можно заполнить значениями еще при создании:
        int[] intArr2 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        System.out.println(Arrays.toString(intArr2)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Можно создавать и двумерные и трехмерные и сколь угодно мерные массивы:
        int[][] intArr2d = new int[10][10];
        int[][][] intArr3d = new int[10][10][10];
        int[][][][] intArr4d = new int[10][10][10][10];

        // На самом деле это массивы массивов, и массивы следующих уровней можно даже не
        // инициализировать:
        int[][] intArr2d2 = new int[10][];

        // А сделать это позже, и, например, придать треугольную форму:
        for (int i = 0; i < intArr2d2.length; i++) {
            intArr2d2[i] = new int[i];
        }

        /*
            []
            [0]
            [0, 0]
            [0, 0, 0]
            [0, 0, 0, 0]
            [0, 0, 0, 0, 0]
            [0, 0, 0, 0, 0, 0]
            [0, 0, 0, 0, 0, 0, 0]
            [0, 0, 0, 0, 0, 0, 0, 0]
            [0, 0, 0, 0, 0, 0, 0, 0, 0]
         */
        print2dArr(intArr2d2);

        // Или даже пилообразную:
        for (int i = 0; i < intArr2d2.length; i++) {
            intArr2d2[i] = new int[i % 5];
        }

        /*
            []
            [0]
            [0, 0]
            [0, 0, 0]
            [0, 0, 0, 0]
            []
            [0]
            [0, 0]
            [0, 0, 0]
            [0, 0, 0, 0]
         */
        print2dArr(intArr2d2);
    }

    public static void arrayCopy() {
        int[] intArr1 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        // Массивы могут быть скопированы при помощи метода clone()
        int[] clone1 = intArr1.clone();

        System.out.println(Arrays.toString(clone1)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        // Или с помощью системного метода:
        int[] clone2 = new int[10];

        System.arraycopy(intArr1, 0, clone2, 0, 10);

        System.out.println(Arrays.toString(clone2)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
    }

    public static void accessArrayElements() {
        // К элементам массива можно получить доступ при помощи индекса:
        int[] intArr = new int[10];

        System.out.println(intArr[5]); // 5

        intArr[5] = 123456;

        System.out.println(intArr[5]); // 123456

        // Массив хранит свою длину
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = i;
        }

        // Или с помощью цикла foreach:
        for (int i : intArr) {
            System.out.print(i);
        }

        System.out.println();
    }

    public static void arrayComparison() {
        // Массивы нельзя сравнивать с помощью equals() или ==
        int[] arr1 = new int[10];
        int[] arr2 = new int[10];

        System.out.println(arr1.equals(arr2)); // false
        System.out.println(arr1 == arr2); // false

        // Правильно массивы сравнивать по содержимому, например, как это делает
        // Arrays.equals()
        System.out.println(Arrays.equals(arr1, arr2)); // true
    }

    public static void operations() {
        // Множество полезных операций над массивами содержит
        // утилитарный класс Arrays
        int[] arr1 = new int[10];

        Arrays.fill(arr1, 1);

        System.out.println(Arrays.toString(arr1)); // [1, 1, 1, 1, 1, 1, 1, 1, 1, 1]

        arr1 = new int[]{4, 3, 7, 1, 9, 2, 0, 8, 6, 5};

        Arrays.sort(arr1);

        System.out.println(Arrays.toString(arr1)); // [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

        System.out.println(Arrays.binarySearch(arr1, 7)); // 7

        int[] arr2 = Arrays.copyOf(arr1, 5);

        System.out.println(Arrays.toString(arr2)); // [0, 1, 2, 3, 4]

        int[] arr3 = Arrays.copyOfRange(arr1, 1, 8);

        System.out.println(Arrays.toString(arr3)); // [1, 2, 3, 4, 5, 6, 7]
    }

    public static void print2dArr(int[][] int2dArr) {
        for (int i = 0; i < int2dArr.length; i++) {
            System.out.println(Arrays.toString(int2dArr[i]));
        }
    }


}
