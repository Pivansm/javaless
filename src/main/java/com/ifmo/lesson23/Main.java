package com.ifmo.lesson23;

import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futur = new FutureTask<>(new Callable<String>() {

            @Override
            public String call() throws Exception {
                return "Hshhahh";
            }
        });

        new Thread(futur).start();

        String ou = futur.get();

        /*CompletableFuture<String> cf = ComletableFuture
                .sypplyAsync()*/
    }

}
