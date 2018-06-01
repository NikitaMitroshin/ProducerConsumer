package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Receiver implements Runnable {
    private Data load;
    private String receivedMessage;

    public Receiver(Data load) {
        this.load = load;
    }

    public void run() {
        while (!"End".equals(receivedMessage)) {

            receivedMessage = load.receive();
            System.out.println(receivedMessage);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 5000));
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}
