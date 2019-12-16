package com.ifmo.lesson18;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        /*WeatherData weatherData = new WeatherData();
        GreeenConditionsDisplay greeenConditionsDisplay = new GreeenConditionsDisplay(weatherData);
        OrangeConditionsDisplay orangeConditionsDisplay = new OrangeConditionsDisplay(weatherData);
        RedConditionsDisplay redConditionsDisplay = new RedConditionsDisplay(weatherData);

        for (int i = 0; i < 200; i++) {
            weatherData.setMeasurements(10.0f + i);
         }*/

        File src = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap.txt");
        File dst = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap_copy.txt");
        File key = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap_key.txt");

        //try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
        //     copy(in, out);
        // }

        //File pth =  new File("C:\\JavaLess\\src\\main\\java\\resources\\");
        //List<File> cuFl = split(dst, pth, 2048);

        //assembly(cuFl, dst);

        //try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
        //    encrypt(in, out, "helloy");
        //    //encrypt(in, out, "helloy");
        //}

        //encrypt(src, dst, key);

    }
}
