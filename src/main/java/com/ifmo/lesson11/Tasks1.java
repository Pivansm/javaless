package com.ifmo.lesson11;

import com.ifmo.lesson11.inner.Message;
import com.ifmo.lesson11.inner.MessageGenerator;
import com.ifmo.lesson11.inner.MessagePriority;

import java.util.*;


/**
 * Created by xmitya on 17.10.16.
 */
public class Tasks1 {

    public static void main(String[] args) {
        MessageGenerator generator = new MessageGenerator();

        List<Message> messages = generator.generate(100);

        countEachPriority(messages);
        countCountEachCode(messages);
        countUniqueMessages(messages);

        System.out.println("Genuine messages in natural order: \n" + genuineMessagesInOriginalOrder(messages));

        removeEach(generator.generate(100), MessagePriority.LOW);
        removeOther(generator.generate(100), MessagePriority.URGENT);
    }

    private static void countEachPriority(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого приоритета.
        // Ответ необходимо вывести в консоль.
        Map<MessagePriority, Integer> map = new IdentityHashMap<>();

        for(Message ms : messages) {

            if(map.containsKey(ms.getPriority())) {
                int pr = map.get(ms.getPriority());
                map.put(ms.getPriority(),  pr + 1);
            }
            else  map.put(ms.getPriority(), 1);
        }
        // TODO implement
        for(Map.Entry<MessagePriority, Integer> item : map.entrySet()){
            MessagePriority msprty = item.getKey();
            int cntSbj = item.getValue();
            System.out.printf("Message: priority %s count %s\n", msprty, cntSbj );
        }
        System.out.println("==");
    }

    private static void countCountEachCode(List<Message> messages) {
        // Сосчитайте количество сообщений для каждого кода сообщения.
        // Ответ необходимо вывести в консоль.

        // TODO implement
        Map<Integer, Integer> map = new HashMap<>();

        for(Message ms : messages) {
            if(map.containsKey(ms.getCode())) {
                int pr = map.get(ms.getCode());
                map.put(ms.getCode(), pr+1);
            }
            else  map.put(ms.getCode(), 1);
        }
        // TODO implement
        for(Map.Entry<Integer, Integer> item : map.entrySet()){
            Integer msprty = item.getKey();
            int cntSbj = item.getValue();
            System.out.printf("Message: code %s count %s\n", msprty, cntSbj );
        }
        System.out.println("==");

    }

    private static void countUniqueMessages(List<Message> messages) {
        // Сосчитайте количество уникальных сообщений.
        // Ответ необходимо вывести в консоль.
        Set<String> st = new HashSet<>();

        for(Message ms : messages) {
            st.add(ms.getPriority().toString() + ms.getCode());
         }

        // TODO implement
        System.out.printf("Message: unique count %s\n", st.size());
        System.out.println("==");
    }

    private static List<Message> genuineMessagesInOriginalOrder(List<Message> messages) {
        // Здесь необходимо вернуть только неповторяющиеся сообщения и в том порядке, в котором
        // они встречаются в первоначальном списке. Например, мы на входе имеем такие сообщения:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}],
        // то на выходе должны получить:
        // [{URGENT, 4}, {HIGH, 9}, {LOW, 3}].
        // Т.е. остались только уникальные значения, и порядок их поступления сохранен.

        // TODO implement

        Set<String> st = new HashSet<>();
        List<Message> oulst = new ArrayList<>();

        for(Message ms : messages) {

            if(!st.contains(ms.getPriority().toString() + ms.getCode()))
            {
                oulst.add(ms);
            }
            st.add(ms.getPriority().toString() + ms.getCode());
        }

        return oulst;
    }

    private static void removeEach(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции каждое сообщение с заданным приоритетом.
        System.out.printf("Before remove each: %s, %s\n", priority, messages);

        List<Message> currms = new ArrayList<>();
        for(Message ms : messages) {
            if(priority.equals(ms.getPriority())) {
                currms.add(ms);
            }

        }
        // TODO implement
        messages.removeAll(currms);
        System.out.printf("After remove each: %s, %s\n", priority, messages);
    }

    private static void removeOther(Collection<Message> messages, MessagePriority priority) {
        // Удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет.
        System.out.printf("Before remove other: %s, %s\n", priority, messages);

        // TODO implement
        List<Message> currms = new ArrayList<>();
        for(Message ms : messages) {
            if(!priority.equals(ms.getPriority())) {
                currms.add(ms);
            }

        }
        // TODO implement
        messages.removeAll(currms);

        System.out.printf("After remove other: %s, %s\n", priority, messages);
    }
}
