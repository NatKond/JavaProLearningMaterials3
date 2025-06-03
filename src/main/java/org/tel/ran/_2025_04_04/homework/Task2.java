package org.tel.ran._2025_04_04.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

//2*. Вы едете на экскурсии. Каждый человек, при входе в автобус, называет свою фамилию.
//Экскурсовод ставит у себя в блокноте птичку и если количество людей по списку совпадает
//автобус уезжает на экскурсию. Сымитируйте данный процесс работы.
//Какой синхронизатор с библиотеки concurrent Вы бы использовали для данного процесса?

public class Task2 {
    public static void main(String[] args) {
        // список людей, которые желают поехать на экскурсию
        String[] personNames = new String[]{"Roman", "Alena", "Kira", "Anna", "Leo", "Bob", "Vladislav", "Inna"};

        CyclicBarrier cyclicBarrier = new CyclicBarrier(personNames.length, new Bus());

        for (String personName : personNames) {
            new Thread(new Tourist(personName, cyclicBarrier)).start();
        }

    }
}

class Tourist implements Runnable {
    private String personName;
    private CyclicBarrier cyclicBarrier;

    public Tourist(String personName, CyclicBarrier cyclicBarrier) {
        this.personName = personName;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {

        System.out.println("-> " + personName + " is sitting in Bus");

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(personName + " is going on a field trip");
    }
}

class Bus implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println("The bus departs");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

