package org.tel.ran._2025_04_02.store;

public class Store {

    private int product = 0;

    public synchronized void get() {  // метод покупателя
        while (product < 1) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product--;
        System.out.println(Thread.currentThread().getName() + " купил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }

    public synchronized void put() { // метод поставщика
        while (product >= 3) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        product++;
        System.out.println(Thread.currentThread().getName() + " добавил 1 товар");
        System.out.println("Товаров на складе: " + product);
        notify();
    }
}
