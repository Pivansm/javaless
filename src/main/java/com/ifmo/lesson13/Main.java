package com.ifmo.lesson13;

import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("");
        int sum = stream.map(s -> s.length())
                .reduce(0, (i1, i2) -> i1 + i2);
        // ;

    }
}
