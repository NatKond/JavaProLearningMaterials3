package org.tel.ran._2025_04_08.homework.Task2;

import java.util.concurrent.Phaser;

public class Author {
    public static void main(String[] args) {

        Phaser phaser = new Phaser();

        String name = "Steaven King";

        // 1 Phase

        phaser.register();

        System.out.println(phaser.getPhase() + 1 + " - The book is being written");
        System.out.println(name + "is writing g a book");

        new Thread(new Coauthor("Peter Straub", phaser)).start();
        new Thread(new Coauthor("Owen King", phaser)).start();

        phaser.arriveAndAwaitAdvance();

        // 2 Phase

        System.out.println(phaser.getPhase() + 1 + " - The book is being reviewed");

        new Thread(new Reviewer("Reviewer1", phaser)).start();
        new Thread(new Reviewer("Reviewer2", phaser)).start();
        new Thread(new Reviewer("Reviewer3", phaser)).start();

        phaser.arriveAndAwaitAdvance();


        // 3 Phase

        System.out.println(phaser.getPhase() + 1 + " - The book is in a publishing house");

        new Thread(new ChiefEditor("ChiefEditor", phaser)).start();
        new Thread(new PublishingHouseChief("PublishingHouseChief", phaser)).start();

        phaser.arriveAndAwaitAdvance();

        // 4 Phase

        System.out.println(phaser.getPhase() + 1 + " - The book is been printed");

        new Thread(new Pressmen("Pressmen1", phaser)).start();
        new Thread(new Pressmen("Pressmen2", phaser)).start();
        new Thread(new Pressmen("Pressmen3", phaser)).start();

        phaser.arriveAndAwaitAdvance();

        // 4 Phase

        System.out.println(phaser.getPhase() + 1 + " - The book is been bound");

        new Thread(new BookBinder("BookBinder1", phaser)).start();
        new Thread(new BookBinder("BookBinder2", phaser)).start();

        phaser.arriveAndAwaitAdvance();

        // 5 Phase

        System.out.println(phaser.getPhase() + 1 + " - The book is been delivered");

        new Thread(new DeliveryService("DeliveryService", phaser)).start();

        phaser.arriveAndDeregister();
    }


}
