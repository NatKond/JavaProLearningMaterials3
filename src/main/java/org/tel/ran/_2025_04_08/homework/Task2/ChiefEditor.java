package org.tel.ran._2025_04_08.homework.Task2;

import java.util.concurrent.Phaser;

public class ChiefEditor implements Runnable {

    String name;

    Phaser phaser;

    public ChiefEditor(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();

        System.out.println(name + " is reading the book");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister();
    }
}
