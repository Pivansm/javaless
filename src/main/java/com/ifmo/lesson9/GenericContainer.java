package com.ifmo.lesson9;

public class GenericContainer<T> {
    private T item;
    public GenericContainer(T item) {
        this.item = item;
    }
    public T getOrElse(T dflt) {
        return item == null ? dflt : item;
    }
}
