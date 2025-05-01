package org.tel.ran._2025_03_28.homework;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static final int START = 2;
    public static final int END = 1_000_000;
    public static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) throws InterruptedException {
        List<MyThread> threads = createThreads();

        threads.forEach(Thread::start);

        for (MyThread thread : threads) {
            Thread.sleep(50);
            System.out.println(thread.getName() + " " + thread.getState());
            thread.interrupt();
        }
    }

    public static List<MyThread> createThreads() {
        List<MyThread> threads = new ArrayList<>();
        int step = (END - START) / NUMBER_OF_THREADS + 1;
        for (int i = 0; i < NUMBER_OF_THREADS - 1; i++) {
            threads.add(new MyThread(START + step * i, START - 1 + step * (i + 1)));
        }
        threads.add(new MyThread(START + step * (NUMBER_OF_THREADS - 1),
                END));

        return threads;
    }
}
