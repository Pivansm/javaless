package com.ifmo.lesson24;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UPDSender {
    public static void main(String[] args) {
        String fileName = "C:\\JavaLess\\src\\main\\java\\resources\\wap.txt";
        try(FileInputStream fr = new FileInputStream( new File(fileName))) {
            byte[] data = new byte[1024];
            DatagramSocket datagramSocket = new DatagramSocket();
            InetAddress address = InetAddress.getLocalHost();
            DatagramPacket packet;

            while (fr.read(data) != -1) {
                packet = new DatagramPacket(data, data.length, address, 8033);
                datagramSocket.send(packet);
            }

            System.out.println("Файл успешно отправлен");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
