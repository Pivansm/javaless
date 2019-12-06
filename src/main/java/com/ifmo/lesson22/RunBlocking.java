package com.ifmo.lesson22;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.concurrent.*;

public class RunBlocking {
    public static Map<String, Integer> map = new HashMap<>();
    public static final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(10);
    public static BlockingQueue<Map<String, Integer>> counts = new ArrayBlockingQueue<>(10);

    private static final String POISON_PILL = new String();



    public static void main(String[] args) throws IOException, InterruptedException {
        int i1 = Runtime.getRuntime().availableProcessors();
        File text = new File("C:\\JavaLess\\src\\main\\java\\resources\\wap.txt");

        // Вычитываем все строки из файла
        List<String> lines = Files.readAllLines(text.toPath());

        //Lines
        (new Thread(new ProducerLines(lines))).start();
        //Map
        (new Thread(new ConsumerMap())).start();

        //Lines
        (new Thread(new ProducerMap())).start();
        //Map
        (new Thread(new Top10Words())).start();

        Thread.currentThread().join(1000);
        System.out.println(map);
    }


    public static class ProducerLines implements Runnable
    {
        List<String> lines;

        public ProducerLines(List<String> lines) {
            this.lines = lines;
        }
        public void run() {
            System.out.printf("Thread put (%s)\n", Thread.currentThread().getName());
            try
            {
                for (String line : lines) {
                    // Для каждой строки
                    String[] wordSplit =
                            line.toLowerCase() // Переводим в нижний регистр
                                    .replaceAll("\\p{Punct}", " ") // Заменяем все знаки на пробел
                                    .trim() // Убираем пробелы в начале и конце строки.
                                    .split("\\s"); // Разбиваем строки на слова

                    for (String s : wordSplit) {
                        // Выбираем только непустые слова.
                        if (s.length() > 0) {
                            queue.put(s);
                            //System.out.println(s.trim());
                        }
                    }
                }
                queue.put(POISON_PILL);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class ConsumerMap implements Runnable
    {
        public void run() {
            System.out.printf("Thread take(%s)\n", Thread.currentThread().getName());
            try
            {
                String s = null;
                while(!((s = queue.take()).equals(POISON_PILL))) {

                    if (map.containsKey(s)) {
                        int pr = map.get(s);
                        map.put(s, pr + 1);
                    } else map.put(s, 1);

                    //System.out.println("" + s);
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static class ProducerMap implements Runnable
    {

         public void run() {
            System.out.printf("Thread put (%s)\n", Thread.currentThread().getName());
            try
            {

                for(Map.Entry<String, Integer> item : map.entrySet()){
                    String str = item.getKey();
                    int i = item.getValue();
                    counts.put(new LinkedHashMap<>((Map<? extends String, ? extends Integer>) item));
                    System.out.printf("S %s I: %s : count %s\n", str, i);
                }

                counts.put((Map<String, Integer>) new LinkedHashMap<>().put(POISON_PILL, 0));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Top10Words implements Runnable {

        public void run() {

            List<Map.Entry<String, Integer>> ls = new LinkedList<Map.Entry<String, Integer>>();
            try {
                while(true) {
                    Map.Entry<String, Integer> cu = (Map.Entry<String, Integer>) counts.take();
                    ls.add((Map.Entry<String, Integer>) counts.take());
                    if(cu.getKey() == POISON_PILL) break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            Collections.sort(ls, new Comparator<Map.Entry<String, Integer>>() {
                @Override
                public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            });

            int k = 1;
            for (Map.Entry<String, Integer> entry : ls) {
                map.put(entry.getKey(), entry.getValue());
                if (k == 10) break;
                k++;
            }
        }

    }


}
