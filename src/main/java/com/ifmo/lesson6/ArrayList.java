package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Этот класс должен реализовывать следующие методы: add(), get(), remove() и iterator() из интерфейса List.
 * Если при выполнении add() в массиве нет свободных элементов, то создать новый - вдвое больше,
 * скопировать в него все значения из старого и + 1, который сейчас добавляется.
 * Удаление должно сдвинуть все элементы влево, если это требуется.
 * Например, если список с такими элементами:
 * |0|1|2|3|4|5|
 * Удаляем элемент по индексу 2:
 * |0|1|_|3|4|5|
 * Перемещаем все элементы влево:
 * |0|1|3|4|5|_|
 * Теперь при итерации по ним после 1 будет идти сразу 3, как в связном списке.
 */
public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_SIZE = 10;

    private Object[] values;
    private int pointer;

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива по умолчанию.
     */
    public ArrayList() {

        this(DEFAULT_SIZE);
    }

    /**
     * Создаёт новый {@link #ArrayList} с размером внутреннего массива,
     * равного {@code initialSize}.
     *
     * @param initialSize Начальный размер внутреннего массива.
     */
    public ArrayList(int initialSize) {

        values = new Object[initialSize];
        this.pointer = 0;
    }

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        // TODO implement.
        if(pointer == values.length-1)
            resize(values.length*2); // увеличу в 2 раза, если достигли границ
        values[pointer++] = val;

    }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        // TODO implement.
        if(i > values.length -1  || i < 0)   return null;
        return (T) values[i];
    }

    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(values, 0, newArray, 0, pointer);
        values = newArray;
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        // TODO implement.
        if(i > values.length - 1 || i < 0)   return null;
        Object it = values[i];
        for (int j = i; j<pointer; j++)
            values[j] = values[j+1];
        values[pointer] = null;
        pointer--;
        return (T)it;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        // TODO implement.
        Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < pointer && values[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T)values[currentIndex++];
            }
        };
         return it;
    }
}
