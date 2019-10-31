package com.ifmo.lesson6;

import java.util.Iterator;

/**
 * Односвязный список, где каждый предыдущий
 * элемент харнит ссылку на следующий. Список
 * оканчивается ссылкой со значением {@code null}.
 */
public class LinkedList implements List, Stack, Queue {
    /** Ссылка на первый элемент списка. */
    private Item head;

    public void setNext(Item node) {
        head.next = node;
    }
    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        // TODO implement.
        Item newItem = new Item(val);
        if (head == null) {
            newItem.next = null;
            head = newItem;
            return;
        }
        else {
            for (Item prev = head;;) {
                 Item next = prev.next;

                if (next == null) {
                    next =  newItem;
                    return;
                }
                  prev = next;
            }
        }

    }

    /** {@inheritDoc} */
    @Override
    public Object take() {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Object get(int i) {
        // TODO implement.
        Item f = head;
        int current = 0;
        if(i < 0) return null;
        if(i == 0 && head != null) return head.value;
        while(current != i) {
            f = f.next;
            current++;
        }
        return f.value;
    }

    /** {@inheritDoc} */
    @Override
    public Object remove(int i) {
        // TODO implement.

        return null;
    }

    /** {@inheritDoc} */
    @Override
    public Iterator iterator() {
        // TODO implement.
        Iterator it = new Iterator() {
            Item current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public Object next() {
                if(hasNext()) {
                    Object data = current.value;
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
    public void push(Object value) {
        // TODO implement.
    }

    /** {@inheritDoc} */
    //Извлечь первый элемент из стека
    @Override
    public Object pop() {
        // TODO implement.

        return null;
    }
}
