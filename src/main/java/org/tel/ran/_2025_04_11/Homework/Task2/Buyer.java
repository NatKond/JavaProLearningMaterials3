package org.tel.ran._2025_04_11.Homework.Task2;

public class Buyer implements Runnable{

    private int number;

    private long timeService;

    public Buyer(int number, long timeService) {
        this.number = number;
        this.timeService = timeService;
    }


    @Override
    public void run() {

        System.out.println("+ Buyer " + number + " enters the store : " + Thread.currentThread().getName());

        try {
            Thread.sleep(timeService); // иммитируем время обслуживания
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("- Buyer " + number + " leaves the store : " + Thread.currentThread().getName());
    }
}
