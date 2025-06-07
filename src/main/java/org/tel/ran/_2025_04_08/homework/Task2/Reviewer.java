package org.tel.ran._2025_04_08.homework.Task2;

import java.util.concurrent.Phaser;

public class Reviewer implements Runnable{

    private String name;

    private Phaser phaser;

    public Reviewer(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();

        System.out.println(name + " is checking the book for the correct reflection of the facts");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister();
    }
}
