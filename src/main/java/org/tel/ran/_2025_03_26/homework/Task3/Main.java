package org.tel.ran._2025_03_26.homework.Task3;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final long START = Integer.MIN_VALUE;
    public static final long END = Integer.MAX_VALUE;
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {

        int number = getNumber();

        int numberOfThreads = getNumberOfThreads();

        System.out.println("-".repeat(5) + " 1 THREAD " + "-".repeat(5));
        MyThread thread1 = new MyThread(START, END, number);
        long currentTime = System.currentTimeMillis();
        thread1.start();
        thread1.join();
        System.out.println("Количество = " + thread1.getCount());
        System.out.println("Время выполнения = " + (System.currentTimeMillis() - currentTime));

        System.out.println("-".repeat(5) + " " + numberOfThreads + " THREAD " + "-".repeat(5));
        currentTime = System.currentTimeMillis();
        List<MyThread> threads = createThreads(numberOfThreads, number);

        threads.forEach(Thread::start);
        for (MyThread thread : threads) {
           thread.join();
        }

        int count = 0;
        for (MyThread thread : threads) {
            count += thread.getCount();
        }
        System.out.println("Время выполнения = " + (System.currentTimeMillis() - currentTime));
        System.out.println("Количество = " + count);
    }

    public static List<MyThread> createThreads(int numberOfThreads, int number) {
        List<MyThread> threads = new ArrayList<>();
        long step = (END - START) / numberOfThreads + 1;
        for (int i = 0; i < numberOfThreads - 1; i++) {
            threads.add(new MyThread(START + step * i,
                    START - 1 + step * (i + 1), number));
        }
        threads.add(new MyThread(START + step * (numberOfThreads - 1),
                END, number));

        return threads;
    }

    public static int getNumber() {
        System.out.print("Enter the divisor: ");
        return SCANNER.nextInt();
    }

    public static int getNumberOfThreads() {
        System.out.print("Enter the number of threads: ");
        return SCANNER.nextInt();
    }
}
