package com.ifmo.lesson13;

import java.util.stream.*;
import java.util.*;

public class CollectToList {
    public static void main(String[] args) {
        //Создание List
        //List<String> collected = Stream.of("a", "Ь", "с") .collect(Collectors.toList());

        //Преобразование строк в верхний регистр с помощью map
        List<String> collected = Stream.of("a", "Ь", "hello")
                .map(string -> string.toUpperCase())
                .collect(Collectors.toList());

        /*List<String> beginningWithNumbers = Stream.of("a", "labc", "abcl")
                .filter(value -> isDigit(value.charAt(0)))
                .collect(Collectors.toList());*/
    }
}
