package com.ifmo.lesson12;

public interface Predicate<T> {
    boolean isValid(T value);
}
