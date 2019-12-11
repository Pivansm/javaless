package com.ifmo.lesson24;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPRecipient {

    private static void acceptFile(File file, int port, int pacSize)  {
        byte[] data = new byte[pacSize];
        DatagramPacket packet = new DatagramPacket(data, data.length);
        try(FileOutputStream os = new FileOutputStream(file)) {
            DatagramSocket datagramSocket = new DatagramSocket(port);
            datagramSocket.setSoTimeout(60_000);
            while (true) {
                datagramSocket.receive(packet);
                os.write(data);
                os.flush();
            }

        } catch (SocketException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File file = new File("C:\\JavaLess\\src\\main\\java\\resources\\UPDwap.txt");
        System.out.println("Прием данных...");

        acceptFile(file, 8033, 1024);
        System.out.println("Файл получен");
    }
}
