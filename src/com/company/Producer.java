package com.company;

//поток производителя
public class Producer implements Runnable {
    private Store store; // склад, куда товар кладем

    public Producer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 6; i++) {
            store.put();
        }
    }
}
