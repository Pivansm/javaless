package com.ifmo.lesson2;

import java.util.Random;

public class IsInInterval {
    /*
     Создать программу, которая будет проверять попало ли случайно выбранное из отрезка
    [5;155] целое число в интервал (25;100) и сообщать результат на экран.Примеры работы
    программы:
    Число 113 не содержится в интервале (25,100) Число 72 содержится в интервале (25,100) 
    Число 25 не содержится в интервале (25,100) Число 155 не содержится в интервале (25,100) 
     */
    public static void main(String[] args) {
        int rnd = randomInt();

        String inInterval = isInInterval(rnd);

        System.out.println(inInterval);
        // TODO implement
    }

    public static int randomInt() {
        // TODO implement
        Random ran = new Random();
        int i = ran.nextInt(150)+5;
        return i;
    }

    public static String isInInterval(int rnd) {
        // TODO implement
        String ost = "";
        if(rnd<25 || rnd > 100)
            ost = "Число " + rnd + " не содержится в интервале (25,100) ";
        else
            ost = "Число " + rnd + " содержится в интервале (25,100) ";

        return ost;
    }

}
