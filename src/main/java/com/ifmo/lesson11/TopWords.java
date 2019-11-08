package com.ifmo.lesson11;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.KeyStore;
import java.text.CollationKey;
import java.text.Collator;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class TopWords {
    public static void main(String[] args) throws IOException {
        // Создаем файл, указывая путь к текстовому файлу на диске
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

        System.out.println(top10Words(words));
        //System.out.println(top10Phrases(words));
        System.out.println(charactersFrequency(words));
    }

    public static Map<String, Integer> top10Words(List<String> lines) {
        // todo implement
        Map<String, Integer> map = new HashMap<>();

        for(String s : lines) {
            if(map.containsKey(s)) {
                int pr = map.get(s);
                map.put(s,  pr+1);
            }
            else  map.put(s, 1);
        }

        /*Map<String, Integer> sortedM = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));*/
        List<Map.Entry<String, Integer>> ls = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortMap = new LinkedHashMap<>();
        int k = 1;
        for(Map.Entry<String, Integer> entry : ls) {
            sortMap.put(entry.getKey(), entry.getValue());
            if(k == 10) break;
            k++;
        }
        return sortMap;
    }

    public static Map<String, Integer> top10Phrases(List<String> lines) {
        // todo implement
        Map<String, Integer> map = new HashMap<>();
        for(String s : lines) {
            if(map.containsKey(s)) {
                int pr = map.get(s);
                map.put(s,  pr+1);
            }
            else  map.put(s, 1);
        }

        /*Map<String, Integer> sortedM = map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));*/
        List<Map.Entry<String, Integer>> ls = new LinkedList<Map.Entry<String, Integer>>(map.entrySet());
        Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortMap = new LinkedHashMap<>();
        int k = 1;
        for(Map.Entry<String, Integer> entry : ls) {
            sortMap.put(entry.getKey(), entry.getValue());
            if(k == 10) break;
            k++;
        }
        return sortMap;

    }

    public static Map<Character, Integer> charactersFrequency(List<String> lines) {
        // todo implement
        Map<Character, Integer> map = new HashMap<>();

        for(String s : lines) {
            for(int j = 0; j <s.length(); j++) {
                char c = s.charAt(j);
                if (map.containsKey(c)) {
                    int pr = map.get(c);
                    map.put(c, pr + 1);
                } else map.put(c, 1);
            }
        }

        List<Map.Entry<Character, Integer>> ls = new LinkedList<Map.Entry<Character, Integer>>(map.entrySet());
        Collections.sort(ls, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });
        Map<Character, Integer> sortMap = new LinkedHashMap<>();
        int k = 1;
        for(Map.Entry<Character, Integer> entry : ls) {
            sortMap.put(entry.getKey(), entry.getValue());
            if(k == 10) break;
            k++;
        }
        return sortMap;

    }
}
