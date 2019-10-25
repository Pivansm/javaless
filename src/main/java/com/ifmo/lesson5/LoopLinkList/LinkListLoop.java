package com.ifmo.lesson5.LoopLinkList;



import com.ifmo.lesson4.*;

public class LinkListLoop {
    public static void main(String[] args) {
        LinkedList lnk = new LinkedList();
        lnk.add("AAA");
        lnk.add("BBB");
        lnk.add("CCC");
        lnk.add("DDD");
        lnk.add("EEE");
        lnk.add("UUU");

        System.out.print("Цикл " + lnk.hasLoop());


    }


}
