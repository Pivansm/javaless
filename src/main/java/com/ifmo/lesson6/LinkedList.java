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

    /** {@inheritDoc} */
    @Override
    public void add(Object val) {
        // TODO implement.
        if (head == null) {
            head = new Item(val);
            return;
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

        return null;
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

        return null;
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
