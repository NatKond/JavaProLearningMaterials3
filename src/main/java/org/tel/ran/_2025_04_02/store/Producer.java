package org.tel.ran._2025_04_02.store;

public class Producer implements Runnable {

    private Store store;

    Producer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            store.put();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
