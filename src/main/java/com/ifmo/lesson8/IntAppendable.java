package com.ifmo.lesson8;

public class IntAppendable<T extends Number> implements Appendable<T> {

    private T val;

    @Override
    public Appendable<T> append(T value){
        return (Appendable<T>) value;
    }

    @Override
    public T value(){
        return val;
    }
}
