package com.ifmo.lesson8;


public class StringAppendable<T> implements Appendable<T> {


    private T val;
    private String separator;


    public StringAppendable() {
        this.separator = ",";
    }

    @Override
    public StringAppendable<T> append(T value){
        return  (StringAppendable<T>) value;
    }

    @Override
    public T value(){
        return val;
    }

}
