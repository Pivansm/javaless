package com.ifmo.lesson8;

public interface Appendable<T> {
    Appendable<T> append(T tt);
    T value();
}
