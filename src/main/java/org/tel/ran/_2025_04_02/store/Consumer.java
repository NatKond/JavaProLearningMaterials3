package org.tel.ran._2025_04_02.store;

public class Consumer implements Runnable {

    private Store store;

    Consumer(Store store) {
        this.store = store;
    }

    public void run() {
        for (int i = 1; i < 10; i++) {
            store.get(); // забирать товар
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
