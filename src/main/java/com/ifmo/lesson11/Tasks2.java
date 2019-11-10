package com.ifmo.lesson11;

import com.ifmo.lesson10.CollectionUtils;
import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessagePriority;
import com.ifmo.lesson11.inner.User;

import java.util.*;


import static com.ifmo.lesson11.inner.UserGenerator.generate;

/**
 * Created by xmitya on 20.10.16.
 */
public class Tasks2 {
    public static void main(String[] args) {
        System.out.println(generate(10));
    }

    private static void sortByPriority(List<Message> messages, MessagePriority priority) {
        //Map<MessagePriority, Integer> map = new TreeMap<>();
        new Comparator<Message>() {
            @Override
            public int compare(Message e1, Message e2) {
                return e1.getPriority().compareTo(e2.getPriority());
            }
        };
        //messages((Message e1, Message e2) -> e1.getPriority().compareTo(e2.getPriority()));
    }

    private static NavigableSet<User> sortedByCompanyAndName(List<User> users) {

        //Collections<User> cl = new
        return Collections.emptyNavigableSet();
    }

    private static NavigableSet<User> sortedBySalaryAndName(List<User> users) {

        return Collections.emptyNavigableSet();
    }

    private static NavigableSet<User> sortedBySalaryAgeCompanyAndName(List<User> users) {

        return Collections.emptyNavigableSet();
    }

    private static <T> Iterator<T> viewIterator(Iterable<T> it1, Iterable<T> it2) {

        return null;
    }


}
