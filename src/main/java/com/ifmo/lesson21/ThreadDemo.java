package com.ifmo.lesson21;

class NewThread implements Runnable {
    Thread t;

    NewThread() {
        // создать новый, второй поток исполнения
        t = new Thread(this, "Демонстрационный поток");
        System.out.println("Дoчepний поток создан: " + t);
        t.start(); // запустить поток исполнения
    }

    // Точка входа во второй поток исполнения
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Дoчepний поток: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException е) {
            System.out.println("Дoчepний поток прерван.");
        }
        System.out.println("Дoчepний поток завершен.");
    }

}

public class ThreadDemo {
    public static void main(String args[]) {
        new NewThread(); // создать новый поток
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Глaвный поток: " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Глaвный поток прерван.");
        }
        System.out.println("Глaвный поток завершен.");
    }
}

