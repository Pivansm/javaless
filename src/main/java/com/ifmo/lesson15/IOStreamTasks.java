package com.ifmo.lesson15;


import java.io.*;
import java.util.*;


/*
    Реализуйте все методы с использованием потоков ввода-вывода.
 */
public class IOStreamTasks {
    public static void main(String[] args) throws IOException {
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

        encrypt(src, dst, key);

    }

    /**
     * Полностью копирует один поток в другой.
     *
     * @param src Входящий поток.
     * @param dst Выходящий поток.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void copy(InputStream src, OutputStream dst) throws IOException {
        // TODO implement
        try (ByteArrayOutputStream bout = new ByteArrayOutputStream()
              ) {
                byte[] buf = new byte[1024];
                int len;
                while ((len = src.read(buf)) > 0) {
                    bout.write(buf, 0, len);
                }
              dst.write(bout.toByteArray());
         }
    }

    /**
     * Последовательно разбивает файл на несколько более мелких, равных
     * указанному размеру. Последний файл может быть меньше задданого
     * размера.
     *
     * @param file Файл, который будет разбит на несколько.
     * @param dstDir Директория, в которой будут созданы файлы меньшего размера.
     * @param size Размер каждого файла-части, который будет создан.
     * @return Список файлов-частей в том порядке, в котором они должны считываться.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static List<File> split(File file, File dstDir, int size) throws IOException {

        List<File> lFil = new ArrayList<>();

        try (InputStream in = new FileInputStream(file)) {
            byte[] buf = new byte[size];
            int len;
            int nmFil = 1;
            while ((len = in.read(buf)) > 0) {

                File src = new File(dstDir.toPath() + "\\wap"+ nmFil + ".txt");
                OutputStream out = new FileOutputStream(src);
                out.write(buf, 0, len);
                nmFil++;
                lFil.add(src);
                out.close();
            }
        }

        return lFil;
    }

    /**
     * Собирает из частей один файл.
     *
     * @param files Список файлов в порядке чтения.
     * @param dst Файл, в который будут записаны все части.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void assembly(List<File> files, File dst) throws IOException {

         try (OutputStream out = new FileOutputStream(dst)) {

             for(File fl : files) {

                 if(fl.exists()) {
                     try (InputStream in = new FileInputStream(fl)) {
                         byte[] buf = new byte[1024];
                         int len;
                         int nmFil = 1;
                         while ((len = in.read(buf)) > 0) {
                             out.write(buf, 0, len);
                         }
                         in.close();
                     }

                     //fl.delete();
                 }
             }
         }

    }

    /**
     * Шифрует/дешифрует поток с помощью XOR. В качестве ключа используется пароль.
     *
     * @param src Входящий поток, данные которого будут зашифрованы/расшифрованы.
     * @param dst Выходящий поток, куда будут записаны зашифрованные/расшифрованные данные.
     * @param passphrase Пароль.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(InputStream src, OutputStream dst, String passphrase) throws IOException {

        byte[] key = "key".getBytes();

        try (ByteArrayOutputStream bout = new ByteArrayOutputStream()
        ) {
            byte[] buf = new byte[1024];
            int len;
            while ((len = src.read(buf)) > 0) {

                for(int i = 0, j = 0; i<buf.length; i++, j++)
                {
                    if (j == key.length -1)
                        j = 0;
                    buf[i] = (byte) (buf[i] ^ key[j]);
                }
                bout.write(buf, 0, len);
            }
            dst.write(bout.toByteArray());
        }
    }

    /**
     * Шифрует/дешифрует файл с помощью файла-ключа.
     *
     * @param src Файл, который должен быть зашифрован/расшифрован.
     * @param dst Файл, куда будут записаны зашифрованные/расшифрованные данные.
     * @param key Файл-ключ.
     * @throws IOException Будет выброшен в случае ошибки.
     */
    public static void encrypt(File src, File dst, File key) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (Reader reader = new FileReader(key)) {

            char[] buf = new char[512];
            int len;
            while ((len = reader.read(buf)) > 0)
                sb.append(buf, 0, len);

        }

        try(InputStream in = new FileInputStream(src); OutputStream out = new FileOutputStream(dst)) {
            encrypt(in, out, sb.toString());
        }
    }
}
