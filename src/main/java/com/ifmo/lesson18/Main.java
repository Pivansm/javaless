package com.ifmo.lesson18;

import java.io.*;
import java. util. Arrays;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        /*WeatherData weatherData = new WeatherData();
        GreeenConditionsDisplay greeenConditionsDisplay = new GreeenConditionsDisplay(weatherData);
        OrangeConditionsDisplay orangeConditionsDisplay = new OrangeConditionsDisplay(weatherData);
        RedConditionsDisplay redConditionsDisplay = new RedConditionsDisplay(weatherData);

        for (int i = 0; i < 200; i++) {
            weatherData.setMeasurements(10.0f + i);
         }*/

        File src = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap2.txt");
        File dst = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap2_copy.txt");
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

        try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {

            byte[] keyPass = "hello".getBytes();
            CryptoOutputStream cryptoOutputStream = new CryptoOutputStream(out, keyPass);

            //try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
                byte[] buf = new byte[1024];
                int len;
                //while ((len = in.read(buf)) != -1) {
                while ((len = in.read()) != -1) {
                    //bout.write(buf, 0, len);
                    //cryptoOutputStream.write(buf, 0, len);
                    //cryptoOutputStream.write(buf);
                    cryptoOutputStream.write((byte)len);
                }
                //cryptoOutputStream.write(bout.toByteArray());
                //cryptoOutputStream.write(bout.toByteArray());
            //}

            cryptoOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        /////////
        try(InputStream in = new FileInputStream(dst)) {

            byte[] keyPass = "hello".getBytes();
            CryptoInputStream cryptoInputStream = new CryptoInputStream(in, keyPass);

            //try (ByteArrayOutputStream bout = new ByteArrayOutputStream()) {
            byte[] buf = new byte[4];
            int len = 0;
            int countByte = 0;
            while ((len = cryptoInputStream.read(buf)) != -1) {
            //while ((len = cryptoInputStream.read(buf, 0, buf.length)) > 0) {
            //while ((len = cryptoInputStream.read()) != -1) {
                //bout.write(buf, 0, len);
                //cryptoOutputStream.write(buf, 0, len);
                //System.out.println("" + Arrays.toString(buf));
                String s = new String(buf);
                System.out.print("" +s);
                //System.out.print("" + (char) len);
                countByte += len;
            }

            System.out.println("\nВсего байт: " + countByte);
            //cryptoOutputStream.write(bout.toByteArray());
            //cryptoOutputStream.write(bout.toByteArray());
            //}
            cryptoInputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
