package com.company;

/*
 Склад, с которого покупатели будут забирать товар
 и куда производители товар будут приносить
 */
public class Store {
    private int product = 0;
    private boolean available = false;

    // для покупателей
    synchronized void get() {
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Consumer interrupted");
            }
        }
        product--;
        System.out.println("Consumer bought 1 item");
        System.out.println("Items in store = " + product + " (get)");
        notify();
    }

    // для производителей
    synchronized void put() {
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        product--;
        System.out.println("Producer added 1 item");
        System.out.println("Items in store = " + product + " (get)");
        notify();
    }
}
