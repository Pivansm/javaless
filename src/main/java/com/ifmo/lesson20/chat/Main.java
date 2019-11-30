package com.ifmo.lesson20.chat;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println(Thread.currentThread().getName());

        Thread thread = new Thread(new HelloThread(1));
        System.out.println("Before start: " + thread.getState());
        thread.start();


        for (int i = 0; i < 10; i++) {
            Thread thread1 = new Thread(new HelloThread(i));
            thread1.setName("T-" + i);
            thread1.start();
            thread1.interrupt();
        }

        //thread.join();
        thread.interrupt();
        System.out.println("After join: " + thread.getState());

        System.out.println("Конец main!");
    }

    public static class HelloThread implements Runnable {

        private int i;
        public HelloThread(int i) {
            this.i = i;
        }
        @Override
        public void run() {

            while (!Thread.currentThread().isInterrupted()) {
                try {

                    Thread.sleep(100);
                } catch (InterruptedException e) {

                    Thread.currentThread().interrupt();
                    e.printStackTrace();
                }
            }

            System.out.printf("I've got %s! (%s)\n", i, Thread.currentThread().getName());
        }
    }

}
