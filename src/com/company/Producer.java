package com.company;

//поток производителя
public class Producer extends Thread {
    private Store store; // склад, куда товар кладем
    private int product = 5; // склад, куда товар кладем

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product > 0) { // пока у производителя есть товары
                product = product - store.put(); // кладем товар на склад
                System.out.println("Producer should produce " + product + " items");
                sleep(100); //время простоя
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
    }
}
