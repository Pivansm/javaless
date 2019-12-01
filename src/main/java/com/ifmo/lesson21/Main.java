package com.ifmo.lesson21;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {

    public static Map<String, Integer> map = new HashMap<>();
    public static Object object = new Object();

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(Thread.currentThread().getName());

        int i1 = Runtime.getRuntime().availableProcessors();
        File text = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());
        // Создаем пустую коллекцию для слов.
        List<String> words = new ArrayList<>();

        for (String line : lines) {
            // Для каждой строки
            String[] wordSplit =
                    line.toLowerCase() // Переводим в нижний регистр
                            .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                            .trim() // Убираем пробелы в начале и конце строки.
                            .split("\\s"); // Разбиваем строки на слова

            for (String s : wordSplit) {
                // Выбираем только непустые слова.
                if (s.length() > 0)
                    words.add(s.trim());
            }
        }

        int countLs = words.size() / i1;

        List<Thread1> thread = new ArrayList<>();
        int col = 0;
        for (int i = 0; i < i1; i++) {

            List<String> partWord = new ArrayList<>(words.subList(col, countLs + col));
            col += countLs;
            thread.add(new Thread1(partWord));

            //Thread thread1 = new Thread(new Thread1(partWord));
            //thread1.setName("W-" + i);
            //thread1.start();

        }

        // Запускаем потоки
        for (Thread1 adder : thread)
            adder.start();

        // Ждем завершения выполнения
        for (Thread1 adder : thread)
            adder.join();

        //Thread.currentThread().join(1000);
        System.out.println(map);
    }

    public static void top10Words(List<String> lines) {
        // todo implement
        Map<String, Integer> cumap = new HashMap<>();
        for (String s : lines) {
            if (cumap.containsKey(s)) {
                int pr = cumap.get(s);
                cumap.put(s, pr + 1);
            } else cumap.put(s, 1);
        }

        List<Map.Entry<String, Integer>> ls = new LinkedList<Map.Entry<String, Integer>>(cumap.entrySet());
        Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        int k = 1;
        for(Map.Entry<String, Integer> entry : ls) {
            map.put(entry.getKey(), entry.getValue());
            if(k == 10) break;
            k++;
        }
    }

    public static class Thread1 extends Thread {
        List<String> words;

        public Thread1(List<String> words) {
            this.words = words;
        }

        @Override
        public void run() {
            synchronized(object) {
                System.out.printf("I've got! (%s)\n", Thread.currentThread().getName());
                top10Words(words);
            }

        }
    }
}
