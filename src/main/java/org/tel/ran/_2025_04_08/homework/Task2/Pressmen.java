package org.tel.ran._2025_04_08.homework.Task2;

import java.util.concurrent.Phaser;

public class Pressmen implements Runnable{

    private String name;

    private Phaser phaser;

    public Pressmen(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();

        System.out.println(name + " is printing the book");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister();
    }
}
