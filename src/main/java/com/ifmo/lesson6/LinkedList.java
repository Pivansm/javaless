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

    public void setNext(Item node) {
        head.next = node;
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
        if(head == null) return null;
        Item<T> f = head;
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

    /** {@inheritDoc} */
    @Override
    public T remove(int i) {
        // TODO implement.
        if(head == null) return null;
        int j = 0;
        if (i == 0) {
            Item<T> h = head;
            head = head.next;
            return h.value;
        }
        if(head != null) {

            Item<T> h = head;
            Item<T> r = null;
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
