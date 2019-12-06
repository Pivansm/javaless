package com.ifmo.lesson23;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.*;
import java.util.*;

public class WordTopExecutor {

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        int il = Runtime.getRuntime().availableProcessors();

        ExecutorService pool = Executors.newFixedThreadPool(il);

        List<Future<Map<String, Integer>>> futures = new ArrayList<>(il);

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

        int countLs = words.size() / il;

        int col = 0;
        for(int i = 0; i < il; i++) {

            java.util.List<String> partWord = new ArrayList<>(words.subList(col, countLs + col));
            Future<Map<String, Integer>> future = pool.submit(() -> countWords(partWord));
            futures.add(future);
        }

        List<Map<String, Integer>> counts = new ArrayList<>(il);
        for (Future<Map<String, Integer>> future : futures) {
            Map<String, Integer> map = future.get();

            counts.add(map);
        }

        List<String> top10Words = top10(counts);

        System.out.println(top10Words);

        pool.shutdown();
    }

    private static Map<String, Integer> countWords(List<String> lines) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : lines) {
            if (map.containsKey(s)) {
                int pr = map.get(s);
                map.put(s, pr + 1);
            } else map.put(s, 1);
        }

        return map;
    }

    public static List<String> top10(Collection<Map<String, Integer>> counters) {

        List<String> out = new ArrayList<>();

        /*List<Map.Entry<String, Integer>> ls= new LinkedList<Map.Entry<String, Integer>>();
        for(Map<String, Integer> map : counters) {
            ls.add((Map.Entry<String, Integer>) map.entrySet());
        }

        Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });*/

        int k = 1;

            for(Map<String, Integer> map : counters) {

                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    out.add(entry.getKey());
                    if (k == 10) break;
                    k++;
                }
            }

        return out;
    }


}
