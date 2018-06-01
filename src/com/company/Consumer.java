package com.company;

// потребитель
public class Consumer implements Runnable {

    private Store store; // склад, куда товар кладем
    private int product = 0; // склад, куда товар кладем

    public Consumer(Store store) {
        this.store = store;
    }

    @Override
    public void run() {
        try {
            while (product < 5) { // пока количество купленных товаров не будет равно 5
                product = product + store.get(); // покупаем по одному товару
                System.out.println("Consumer bought " + product + " items");
                Thread.sleep(100); //время простоя
            }
        } catch (InterruptedException e) {
            System.out.println("Consumer interrupted");
        }
    }
}
