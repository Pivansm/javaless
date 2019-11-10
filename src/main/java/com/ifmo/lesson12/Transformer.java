package com.ifmo.lesson12;

public interface Transformer<T, R> {
    R transform(T val);
}
