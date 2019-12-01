package com.ifmo.lesson15;

import java.io.*;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        //Random ran = new Random();
        //RandomInputStream randomInputStream = new RandomInputStream(ran, 10);
        //for(int i = 0; i < 100; i++) {
        //    System.out.print("" + randomInputStream.read());
        //}

        SawInputStream sawInputStream = new SawInputStream(5, 1);

        for(int i = 0; i < 100; i++) {
            System.out.print("" + sawInputStream.read() + ", ");
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
