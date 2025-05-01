package org.tel.ran._2025_03_28;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("2." + getState()); //Runnable
        for (int i = 0; i < 1_000; i++) {
            if (i % 500 == 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
