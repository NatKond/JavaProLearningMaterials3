package org.tel.ran._2025_04_01.deadlock;

import static org.tel.ran.textFormatting.*;

public class MainDeadlockPaperScissors implements Runnable {
    private static class Resource {
    }

    private final Resource scissors = new Resource();
    private final Resource paper = new Resource();

    public void doSun() {
        System.out.println(Thread.currentThread().getName() + " тянется за ножницами");
        synchronized (scissors) { // May deadlock here
            System.out.println(Thread.currentThread().getName() + " взяла ножницы для вырезания" + YELLOW + " солнышка" + RESET);
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взяла бумагу для вырезания" + YELLOW + " солнышка" + RESET);
                System.out.println(Thread.currentThread().getName() + " вырезает" + YELLOW + " солнышко" + RESET);
            }
        }
    }

    public void doCloudWithoutDeadLock() {
        System.out.println(Thread.currentThread().getName() + " тянется за ножницами");
        synchronized (scissors) { // May deadlock here
            System.out.println(Thread.currentThread().getName() + " взяла ножницы для вырезания" + BLUE + " облачка" + RESET);
            synchronized (paper) {
                System.out.println(Thread.currentThread().getName() + " взяла бумагу для вырезания" + BLUE + " облачка" + RESET);
                System.out.println(Thread.currentThread().getName() + " вырезает" + BLUE + " облачко" + RESET);
            }
        }
    }

    public void doCloudWithDeadLock() {
        synchronized (paper) { // May deadlock here
            System.out.println(Thread.currentThread().getName() + " взяла бумагу для вырезания " + BLUE + " облачка" + RESET);
            synchronized (scissors) {
                System.out.println(Thread.currentThread().getName() + " взяла ножницы для вырезания" + BLUE + " облачка" + RESET);
                System.out.println(Thread.currentThread().getName() + " вырезает " + BLUE + "  облачко" + RESET);
            }
        }
    }

    @Override
    public void run() {
        doSun();
        // doCloudWithDeadLock();
        doCloudWithoutDeadLock();
    }

    public static void main(String[] args) {
        MainDeadlockPaperScissors job = new MainDeadlockPaperScissors();
        Thread masha = new Thread(job, GREEN + "Маша" + RESET);
        Thread dasha = new Thread(job, PURPLE + "Даша" + RESET);
        masha.start();
        dasha.start();

    }

    private void sleeps(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
