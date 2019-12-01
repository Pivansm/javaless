package com.ifmo.lesson21;

public class Order {
    private String blude;
    boolean flagWaiter;
    boolean flagChef;

    public Order(String blude) {
        this.blude = blude;
        this.flagWaiter = false;
        this.flagChef = false;
    }

    public String getBlude() {
        return blude;
    }
    public boolean getFlagChef() {
        return flagChef;
    }
    public boolean getFlagWaiter() {
        return flagWaiter;
    }
    public void setFlagChef(boolean flag) {
        this.flagChef = flag;
    }
    public void setFlagWaiter(boolean flag) {
        this.flagWaiter = flag;
    }

}
