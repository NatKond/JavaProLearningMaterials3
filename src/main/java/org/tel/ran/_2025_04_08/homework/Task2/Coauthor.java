package org.tel.ran._2025_04_08.homework.Task2;

import java.util.concurrent.Phaser;

public class Coauthor implements Runnable{

    private String name;

    private Phaser phaser;

    public Coauthor(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    @Override
    public void run() {
        phaser.register();

        System.out.println(name + " is writing some chapters");

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        phaser.arriveAndDeregister();
    }
}
