package com.ifmo.lesson19;

import java.util.*;


public class Injector {
    private  Map<Class<?>, Object> singletons = new HashMap<>();

    public <T> T create(String className) {
        try
        {
            final Class<?> cln = Class.forName(className);
        }
        catch(ReflectiveOperationException e)
        {

        }
        return null;
    }

    private Object inject() {
        return null;
    }


}
