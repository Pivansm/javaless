package com.ifmo.lesson15;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        //Random ran = new Random();
        //RandomInputStream randomInputStream = new RandomInputStream(ran, 10);
        //for(int i = 0; i < 100; i++) {
        int r = 0;
        //while((r = randomInputStream.read()) > 0) {
        //    System.out.print(" " + r);
        //}

        r = 0;
        SawInputStream sawInputStream = new SawInputStream(5, 20);
        while ((r = sawInputStream.read()) != -1) {
            System.out.print("" + r + ", ");
        }
    }

    private String readToString(File file) {

        /*try(InputStream in = new FileInputStream(file);
            ByteArrayOutputStream bout = new ByteArrayOutputStream())
        {
            byte[] buf = new byte[1024];
            int len;
            while((len=in.read(buf)) > 0) {
               bout.write(buf, 0, len);
            }
            String
        }*/

        return "";
    }
}
