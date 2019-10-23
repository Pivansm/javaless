package com.ifmo.test;

public class Human {
    String name;

    public Human(String name){
        this.name = name;
    }


    public static void main(String[] args){
        Human john = new Human("John");
        Human johnson = new Human("Johnson");
    }
}
