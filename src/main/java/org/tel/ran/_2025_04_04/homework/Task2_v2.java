package org.tel.ran._2025_04_04.homework;

import java.util.concurrent.CountDownLatch;

public class Task2_v2 {
    public static void main(String[] args) throws InterruptedException {
        // список людей, которые желают поехать на экскурсию
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        CountDownLatch countDownLatch = new CountDownLatch(personNames.length);

        // главный поток иммитирует работу экскурсовода
        for (int i = 0; i < personNames.length; i++) {
            new Thread(new Tourist2(personNames[i], countDownLatch)).start();
            System.out.println(personNames[i] + " отмечен экскурсоводом.");
            countDownLatch.countDown(); // экскурсовод отметил присутствие туриста, уменшили количество ожидаемых туристов на 1
            Thread.sleep(500); //пауза на полсекунду
        }

        System.out.println("===== Автобус повез туристов на экскурсию =======");
    }
}

class Tourist2 implements Runnable {
    private String personName;
    private CountDownLatch countDownLatch;

    public Tourist2(String personName, CountDownLatch countDownLatch) {
        this.personName = personName;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {

        try {
            // список дел, которые буду выполнены в рамках каждого потока (человека) самостоятельно
            System.out.println("-> " + personName + " сел в автобус и ждет.");

            countDownLatch.await(); // когда count==0 все выходят из состояния ожидания

            // финальное - выполнится то, что находится после await() метода
            System.out.println(personName + " с группой едет на экскурсию");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
