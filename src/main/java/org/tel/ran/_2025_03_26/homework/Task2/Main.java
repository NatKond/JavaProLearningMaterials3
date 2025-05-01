package org.tel.ran._2025_03_26.homework.Task2;


import java.util.ArrayList;
import java.util.List;

import static org.tel.ran.textFormatting.GREEN;
import static org.tel.ran.textFormatting.YELLOW;

public class Main {
    public static final int NUMBER = 17;
    public static final int NUMBER_OF_THREADS = 3;
    public static final int START = 0;
    public static final int END = 10_000_000;

    public static void main(String[] args) {
        List<Thread> threads = createThreads();

        threads.forEach(thread -> thread.setDaemon(true));
        threads.forEach(Thread::start);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(YELLOW + "THREAD MAIN IS TERMINATED");
    }

    public static List<Thread> createThreads() {
        List<Thread> threads = new ArrayList<>();
        int step = (END - START) / NUMBER_OF_THREADS;

        for (int i = 0; i < NUMBER_OF_THREADS - 1; i++) {
            threads.add(new MyThread(START + step * i, START + step * (i + 1), NUMBER));
        }
        threads.add(new MyThread(START + step * (NUMBER_OF_THREADS - 1), END, NUMBER));
        return threads;
    }
}
