package org.tel.ran._2025_04_02.message;

import java.util.ArrayList;

public class Subscriber implements Runnable {

    private Message msg;

    ArrayList<String> messages = new ArrayList<>();

    public Subscriber(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 5; i++) {
            synchronized (msg) {
                try {
                    System.out.println(name + " ждет сообщения (notify):");
                    msg.wait();
                    //msg.wait(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(name + " получил " + msg.getMsg());
                messages.add(msg.getMsg());
            }
        }
        System.out.println(name + " : ");
        messages.forEach(System.out::println);
    }
}
