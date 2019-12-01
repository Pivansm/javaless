package com.ifmo.lesson21;

public class Waiter implements Runnable {
    Order order;
    Chef chef;

    public Waiter(Order order) {
        this.order = order;
        chef = new Chef(order);
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал");
        new Thread(chef, "chef").start();
        System.out.println(name + " разбудили шефа!");

        try {
            System.out.println(name + " официант уснул, ждет вызов от шефа : " + System.currentTimeMillis());
            //Thread.sleep(100);

                //
                    synchronized (order) {
                        //order.wait();

                        while (true) {
                            synchronized (CaffeeTest.object) {

                                CaffeeTest.object.wait();

                                if (order.getFlagChef()) {
                                    System.out.println("Блюдо от шефа получено!");
                                    order.setFlagWaiter(true);
                                    break;
                                }
                            }
                        }

                        order.notify();
                    }

                //}
                //order.setFlag(true);
                System.out.println("Заказ для клиента готов!");
                //order.notify();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}

