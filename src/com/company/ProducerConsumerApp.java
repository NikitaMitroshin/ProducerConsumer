package com.company;

public class ProducerConsumerApp {

    public static void main(String[] args) {
        Store store = new Store();
        new Producer(store).start();
        new Thread(new Consumer(store)).start();
    }

}
