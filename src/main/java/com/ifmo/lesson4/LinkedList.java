package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        // TODO implement
        if (head == null) {
            head = new Item(val);
            return;
        }
        //noinspection ConstantConditions
        find(-1).next = new Item(val);
    }

    private Item find(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head;

        int cnt = 1;

        for (Item prev = head;;) {
            Item next = prev.next;

            if (next == null)
                return i < 0 ? prev : null;

            if (cnt++ == i)
                return next;

            prev = next;
        }
    }
    /**
     * Извлекает значение из списка по индексу.
     *
     * @param i Индекс значения в списке.
     * @return Значение, которое находится по индексу
     * или {@code null}, если не найдено.
     */
    public Object get(int i) {
        // TODO implement
        Item item = find(i);

        return item == null ? null : item.value;
    }


    public boolean hasLoop() {

        if(head == null)
            return false;

        Item slow, fast;
        slow = fast = head;

        while(true) {
            slow = slow.next;
            if(fast.next != null)
                fast = fast.next.next;
            else
                return false;

            if(slow == null || fast == null)
                return false;

            if(slow == fast)
                return true;
        }
    }

    /**
     * Удаляет значение по индексу и возвращает
     * удаленный элемент.
     *
     * @param i Индекс, по которому будет удален элемент.
     * @return Удаленное значение или {@code null}, если не найдено.
     */
    public Object remove(int i) {
        // TODO implement
        if (head == null)
            return null;

        if (i == 0) {
            Item h = head;
            head = head.next;
            return h.value;
        }

        Item prev = find(i - 1);
        Item cur;

        if (prev != null && (cur = prev.next) != null) {
            prev.next = cur.next;

            return cur.value;
        }

        return null;
    }


    public static void main(String[] args)
    {
        LinkedList lkl = new LinkedList();

        lkl.add("etewrwt");
        lkl.add("lhkllg");
        lkl.add("kpokytk");

        //lkl.get(2);
        System.out.println(lkl.get(0));
        System.out.println(lkl.get(1));
        System.out.println(lkl.get(2));

        lkl.remove(2);

        System.out.print("-----------\n");
        System.out.println(lkl.get(0));
        System.out.println(lkl.get(1));
        System.out.println(lkl.get(3));


    }
}
