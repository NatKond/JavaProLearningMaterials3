package org.tel.ran._2025_03_26.homework.Task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final Scanner SCANNER = new Scanner(System.in);
    public static void main(String[] args) {

        List<Thread> threads = createThreads(getNumberOfThreads());
        threads.forEach(Thread::start);

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static List<Thread> createThreads(int numberOfThreads){
        List <Thread> threads = new ArrayList<>();
        for (int j = 1; j <= numberOfThreads; j++) {
            threads.add(new MyThread("My Thread " + j));
        }
        return threads;
    }

    public static int getNumberOfThreads(){
        System.out.print("Enter the number of threads: ");
        return SCANNER.nextInt();
    }
}
