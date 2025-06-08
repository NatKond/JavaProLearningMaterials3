package org.tel.ran._2025_04_11.Homework.Task2;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainShop {
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (ExecutorService service = Executors.newFixedThreadPool(10)) {
            for (int i = 1; i <= 1_000; i++) {
                //new Buyer(i+1, 10).start();
                service.execute(new Buyer(i, RANDOM.nextInt(100)));
            }
        }
    }
}
