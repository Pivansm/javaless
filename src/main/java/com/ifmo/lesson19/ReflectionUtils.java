package com.ifmo.lesson19;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public  String toString(Object obj) {
        String nameField = "";
        try {

            Class clazz = obj.getClass();
            nameField = "Class name: {" + clazz.getName();
            Field[] field = obj.getClass().getDeclaredFields();

            for(Field fl : field) {
                Exclude exclude = fl.getAnnotation(Exclude.class);
                if(exclude != null && !exclude.visible()) {
                    continue;
                }
                nameField += " field name: " + fl.getName();
                fl.setAccessible(true);
                nameField += " field param: " + fl.get(obj);
            }
            nameField += "}";

        } catch (Exception e) {
            e.printStackTrace();
        }

        return nameField;
    }
}
