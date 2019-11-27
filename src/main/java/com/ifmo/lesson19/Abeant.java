package com.ifmo.lesson19;

public class Abeant {

    @Exclude(visible = false)
    private int i;

    private String c;

    public Abeant() {
        i = 42;
        c = "Такая строка";
    }
}
