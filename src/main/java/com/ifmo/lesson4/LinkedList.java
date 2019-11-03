package com.ifmo.lesson4;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList {
    /** Ссылка на первый элемент списка. */
    private Item head;

     /*public interface Item {
         public Item getNext();
         public void setNext(Item node);
     }*/

    public Item getHead() {
         return head;
    }
    public void insertAtHead(Item node){
       setNext(head);
       head = node;
    }

    //вставляем узел в конец списка
    public void insertAtTail(Item node) {
         if(head == null) {
             head = node;
         }
         else {
             Item p, q;
             for(p = head; (q = p.next) != null; p = q) {
                 setNext(node);
             }
         }
    }

    //удаляем узел в начале списка
    public Item removeFromHead() {
         Item node = head;
         if(node != null) {
             head = node.next;
             setNext(null);
         }

         return node;
    }

    public Item removeFromTail() {
         if(head == null) return null;
         Item p = head, q = null, nex = head.next;
         if(nex == null) {
             head = null;
             return p;
         }
         while((nex = p.next) != null) {
             q = p;
             p = nex;
         }
         q.next = null;
         return p;
    }


    /**
     * Добавляет значение в конец списка.
     *
     * @param val Значение, которое будет добавлено.
     */
    public void add(Object val) {
        // TODO implement
        Item newItem = new Item(val);
        if (head == null) {
            newItem.next = null;
            head = newItem;
            return;
        }
        else {
            Item it = head;
            while(true) {
                if(it.next == null) {
                    it.next = newItem;
                    return;
                }
                it = it.next;
            }
        }
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
        Item f = head;
        int current = 0;
        if(i < 0) return null;
        if(i == 0 && head != null) return head.value;
        while(current != i) {
            if(f.next == null) { return null; }
            f = f.next;
            current++;
        }
        return f.value;
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

    public void setNext(Item node) {
        head.next = node;
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
        int j = 0;
        if (i == 0) {
            Item h = head;
            head = head.next;
            return h.value;
        }
        if(head != null) {

            Item h = head;
            Item r = null;
            while (true) {
                if (h.next != null && j + 1 == i) {
                    r = h.next;
                    h.next = h.next.next;
                    return r.value;
                }

                if (h.next == null) break;
                j++;
                r = h;
                h = h.next;
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

        lkl.remove(2);

        System.out.print("-----------\n");
        System.out.println(lkl.get(0));
        System.out.println(lkl.get(1));
        System.out.println(lkl.get(3));


    }
}
