package com.ifmo.lesson8;


public class StringAppendable<T> implements Appendable<T> {

    private T val;
    private String separator;

    public StringAppendable(String sepa) {

        this.separator = sepa;
    }

    @Override
    public StringAppendable<T> append(T value){
        String value2 = (String)value + separator;
        value = (T)value2;
        return  (StringAppendable<T>)value;
    }

    @Override
    public T value(){

        return val;
    }

}
