package com.company;

// потребитель
public class Consumer implements Runnable {

    private Store store; // склад, куда товар кладем

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.get();
        }
    }
}
