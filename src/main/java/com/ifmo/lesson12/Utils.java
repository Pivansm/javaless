package com.ifmo.lesson12;

import java.io.PrintStream;
import java.util.*;

public class Utils {


    public static <T> List<T> filter (List<T> list, Predicate<T> filter) {
        List<T> result = new ArrayList<>(list.size());
        for (T item :list) {
            if(filter.isValid(item))
                result.add(item);
        }
        return result;
    }

    public static <T, R> List<R> tr (List<T> list, Transformer<T, R> trn) {
        List<R> result = new ArrayList<>(list.size());
        for (T item :list) {
             result.add(trn.transform(item));
        }
        return result;
    }

    public static <T, R> Iterable<R> view(Predicate<T> filter, Transformer<T, R> transformer, Iterable<R>...iterables){
        if (iterables.length == 0)
            return null;

        return new Iterable<R>() {
            @Override
            public Iterator<R> iterator() {
                return new Iterator<R>() {
                    private int pos;
                    private Iterator<R> current;

                    @Override
                    public boolean hasNext() {
                        if (current == null)
                            current = iterables[pos].iterator();

                        if (!current.hasNext()) {
                            pos++;

                            if (pos < iterables.length) {
                                current = iterables[pos].iterator();
                            } else {
                                return false;
                            }
                        }


                        return current.hasNext();
                    }

                    @Override
                    public R next() {
                        return current.next();
                    }
                };
            }
        };

    }

    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        List<String> strings = new ArrayList<>();
        strings.add("Aaa");
        strings.add("Bbbbb");
        strings.add("Abccc");
        strings.add("Eeaabbcc");
        strings.add("Sssffdd");


        List<Integer> even = filter(integers, i ->  i%2 == 0);
        even.forEach(System.out::println);
        System.out.println("==");

        List<String> stre = filter(strings, i ->  i.length() > 3);
        stre.forEach(System.out::println);
        System.out.println("==");

        List<String> tran = tr(integers, i -> i.toString());
        tran.forEach(System.out::println);
        System.out.println("==");

        List<Integer> trne2 = tr(integers, i -> i*i);
        trne2.forEach(System.out::println);
        System.out.println("==");

        //Iterable<String> view = view(null, null, integers, strings);

    }

}



