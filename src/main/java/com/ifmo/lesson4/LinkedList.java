package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;
    private int _size;

     /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
     public int getSize() {
         return _size;
     }

    public void add(Object val) {
        // TODO implement
       if(head == null)
            head = new Item(val);
       else {
           Item it = head;
           while(true) {
             if(it.next == null) {
                 it.next = new Item(val);
                 _size++;
                 return;
             }
             it = it.next;
           }
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
        int j = 0;
        Item it = head;
        while(true)
        {
            if (j == i) {
                return it.value;
            }
            if(it.next == null) break;
            j++;
            it = it.next;
        }

        return null;
    }

    public Object getNext(int i) {
        // TODO implement
        int j = 0;
        Item it = head;
        while(true)
        {
            if (j == i) {
                return it.next;
            }
            if(it.next == null) break;
            j++;
            it = it.next;
        }

        return null;
    }

    public Object getNext() {
        // TODO implement
        return head.next;
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

            if(slow == null || fast == null) // if either hits null..no loop
                return false;

            if(slow == fast) // if the two ever meet...we must have a loop
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
        int j = 0;
        if(head != null) {
            Item it = head;
            while (true) {
                if (it.next != null && j + 1 == i) {
                    //head.next = it.next;
                    it.next = it.next.next;
                    _size--;
                    return it.value;
                }

                if (it.next == null) break;
                j++;
                it = it.next;
            }
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
        lkl.remove(1);
        System.out.print("\n");
        System.out.println(lkl.get(0));
        System.out.println(lkl.get(1));
        System.out.println(lkl.get(2));


    }
}
