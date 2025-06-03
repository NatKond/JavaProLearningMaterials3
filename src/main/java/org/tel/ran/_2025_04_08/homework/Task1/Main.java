package org.tel.ran._2025_04_08.homework.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Main {
    public static final int NUMBER_OF_THREADS = 3;
    public static final int START = 0;
    public static final int END = 10_000_000;

    public static void main(String[] args) {
       createTasks().forEach(task -> {
            try {
                System.out.println(task.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
    }

    public static List<FutureTask<Integer>> createTasks() {
        List<FutureTask<Integer>> tasks = new ArrayList<>();
        int step = (END - START) / NUMBER_OF_THREADS;

        for (int i = 0; i < NUMBER_OF_THREADS - 1; i++) {
            Callable<Integer> primeCounter = new PrimeCounter(START + step * i, START + step * (i + 1));
            FutureTask<Integer> count = new FutureTask<>(primeCounter);
            tasks.add(count);
            new Thread(count).start();
        }

        Callable<Integer> primeCounter = new PrimeCounter(START + step * (NUMBER_OF_THREADS - 1), END);
        FutureTask<Integer> count = new FutureTask<>(primeCounter);
        tasks.add(count);
        new Thread(count).start();
        return tasks;
    }
}
