package org.tel.ran._2025_04_08.homework.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.stream.Collectors;

public class Main {
    public static final int NUMBER_OF_THREADS = 4;
    public static final int START = 0;
    public static final int END = 10_000_000;

    public static void main(String[] args) {

        // 1 Thread
        FutureTask<Integer> task1 = new FutureTask<>(new PrimeCounter(START, END));

        long startTime = System.currentTimeMillis();
        new Thread(task1).start();
        try {
            System.out.println("Total amount of prime numbers is " + task1.get() + ": " + (System.currentTimeMillis() - startTime));
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        // Multiple Threads
        List<Callable<Integer>> callables = createTasks();

        List<FutureTask<Integer>> tasks = callables.stream().map(FutureTask::new).toList();
        int totalAmount = 0;
        startTime = System.currentTimeMillis();
        tasks.forEach(task -> new Thread(task).start());

        for (FutureTask<Integer> task : tasks) {
            try {
                totalAmount += task.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Total amount of prime numbers is " + totalAmount + ": " + (System.currentTimeMillis() - startTime));
    }

    public static List<Callable<Integer>> createTasks() {
        List<Callable<Integer>> callables = new ArrayList<>();
        int step = (END - START) / NUMBER_OF_THREADS;
        for (int i = 0; i < NUMBER_OF_THREADS - 1; i++) {
            callables.add(new PrimeCounter(START + step * i, START + step * (i + 1)));
        }
        callables.add(new PrimeCounter(START + step * (NUMBER_OF_THREADS - 1), END));
        return callables;
    }
}
