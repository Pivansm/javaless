package com.ifmo.lesson6;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /*List<String> list = new LinkedList<>();

        System.out.println("" + list.get(9));

        list.add("Ax1");
        list.add("Ax2");
        list.add("Ax3");
        list.add("Ax4");
        list.add("Ax5");
        list.add("Ax6");
        list.add("Ax7");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }

        System.out.println("---------");

        System.out.println("" + list.get(1));
        System.out.println("---------");
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));
        System.out.println("" + list.remove(0));

        System.out.println("" + list.get(1));

        System.out.println("---------");

        it = list.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }
        System.out.println("" + list.get(9));

        it = list.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }*/

        /*ArrayList arrayList = new ArrayList(5);
        arrayList.add("Ax1");
        arrayList.add("Ax2");
        arrayList.add("Ax3");
        arrayList.add("Ax4");
        arrayList.add("Ax5");

        Iterator<String> it = arrayList.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }

        System.out.println("" + arrayList.get(1));
        System.out.println("==========");
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.remove(0));
        System.out.println("" + arrayList.get(1));*/

       //Стек
        Stack<String> stack = new LinkedList<>();

        stack.push("Ax1");
        stack.push("Ax2");
        stack.push("Ax3");

        System.out.println("" + stack.pop());
        System.out.println("" + stack.pop());
        System.out.println("" + stack.pop());
        System.out.println("" + stack.pop());

        //Очередь
        Queue<String> ql =new LinkedList<>();

        //System.out.println("" + ql.take());

        ql.add("Ax1");
        ql.add("Ax2");
        ql.add("Ax3");
        ql.add("Ax4");
        ql.add("Ax5");
        ql.add("Ax6");

        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());
        System.out.println("" + ql.take());

        /*Iterator<String> it = ql.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }*/
    }
}
