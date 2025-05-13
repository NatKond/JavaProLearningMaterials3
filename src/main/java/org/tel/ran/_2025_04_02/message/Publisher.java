package org.tel.ran._2025_04_02.message;

public class Publisher implements Runnable {
    private Message msg;

    public Publisher(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " стартовал.");
        try {
            for (int i = 0; i < 5; i++) {
                synchronized (msg) {
                    System.out.println(name + " создал сообщение.");
                    msg.setMsg(name + "  ->  Это сообщение №" + i);
                    // msg.notify(); // один поток получит сигнал
                    msg.notifyAll(); // все потоки, который в wait получат сигнал
                }
                Thread.sleep(1000);
            }


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
