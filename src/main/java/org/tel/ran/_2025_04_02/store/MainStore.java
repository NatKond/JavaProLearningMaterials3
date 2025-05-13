package org.tel.ran._2025_04_02.store;

import static org.tel.ran.textFormatting.*;

public class MainStore {
    public static void main(String[] args) {
        Store store = new Store();

        Producer producer = new Producer(store);
        Consumer consumer = new Consumer(store);

        Thread threadProducer = new Thread(producer, PURPLE + "Producer" + RESET);
        Thread threadConsumer = new Thread(consumer, CYAN + "Consumer" + RESET);

        threadProducer.start();
        threadConsumer.start();
    }
}