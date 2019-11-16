package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList<T> implements List<T>, Stack<T>, Queue<T> {
    /** Ссылка на первый элемент списка. */
    private Item<T> head;

    private Item<T> find(int i) {
        if (head == null)
            return null;

        if (i == 0)
            return head;

        int cnt = 1;

        for (Item<T> prev = head;;) {
            Item<T> next = prev.next;

            if (next == null)
                return i < 0 ? prev : null;

            if (cnt++ == i)
                return next;
            prev = next;
        }
    }

    /** {@inheritDoc} */
    @Override
    public void add(T val) {
        // TODO implement.
        Item<T> newItem = new Item(val);
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

    /** {@inheritDoc} */
    @Override
    public T take() {
        // TODO implement.
        if(head == null) return null;
        Item<T> p = head, q = null, nex = head.next;
        if(nex == null) {
            head = null;
            return p.value;
        }
        while((nex = p.next) != null) {
            q = p;
            p = nex;
        }
        q.next = null;
        return p.value;
      }

    /** {@inheritDoc} */
    @Override
    public T get(int i) {
        // TODO implement.
        Item<T> item = find(i);
        return item == null ? null : item.value;
    }

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        // TODO implement.
        if (head == null) return null;
        if (i == 0) {
            Item<T> h = head;
            head = head.next;
            return h.value;
        }

        Item<T> prev = find(i - 1);
        Item<T> cur;
        if (prev != null && (cur = prev.next) != null) {
            prev.next = cur.next;
            return cur.value;
        }
        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator<T> iterator() {
        // TODO implement.
        Iterator<T> it = new Iterator<T>() {
            Item<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(hasNext()) {
                    T data = current.value;
                    current = current.next;
                    return data;
                }
                return null;
            }
        };
        return it;
    }

    /** {@inheritDoc} */
    //Поместить элемент в стек
    @Override
    public void push(T value) {
        // TODO implement.
        Item<T> insertion = new Item(value);
        if (head == null) {
            head = insertion;
        } else {
            insertion.next = head;
            head = insertion;
        }

     }

    /** {@inheritDoc} */
    //Извлечь первый элемент из стека
    @Override
    public T pop() {
        // TODO implement.
        if(head == null) return null;
        Item<T> node = head;
        if(node != null) {
            head = node.next;
            //if(head.next != null) { head.next = null; }
            return node.value;
        }

        return null;
    }
}
