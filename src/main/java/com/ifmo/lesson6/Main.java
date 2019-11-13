package com.ifmo.lesson6;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        /*List<String> list = new LinkedList<>();
        list.add("Privet1");
        list.add("Da2");
        list.add("Net3");
        list.add("Yfhf[j4");

        System.out.println("" + list.get(1));

        System.out.println("" + list.remove(1));
        System.out.println("" + list.get(1));

        System.out.println("---------");

        Iterator<String> it = list.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }*/

        ArrayList arrayList = new ArrayList();
        arrayList.add("Ax1");
        arrayList.add("Ax2");
        arrayList.add("Ax3");
        arrayList.add("Ax4");
        arrayList.add("Ax5");

        Iterator<String> it = arrayList.iterator();
        while(it.hasNext()) {
            System.out.println("" + it.next());
        }

        System.out.println("" + arrayList.get(2));
        System.out.println("" + arrayList.remove(2));
        System.out.println("" + arrayList.get(2));

       //Стек
      /*  Stack<String> list = new LinkedList<>();

        list.push("wtret1");
        list.push("fgdty2");
        list.push("fgdty3");

        System.out.println("" + list.pop().toString());
        System.out.println("" + list.pop().toString());*/


        //Очередь
        /*Queue<String> ql =new LinkedList<>();

        ql.add("Privet1");
        ql.add("Da2");
        ql.add("Net3");
        ql.add("Yfhf[j4");

        System.out.println("" + ql.take().toString());
        System.out.println("" + ql.take().toString());*/


    }
}
