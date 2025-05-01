package org.tel.ran._2025_03_28;

public class MainState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new MyThread();
        System.out.println("Before start -> " + thread.getState());
        thread.start();

        Thread.sleep(10);
        while (thread.isAlive()){
            System.out.println("--- 3." + thread.getState());
            Thread.sleep(50);
        }

        System.out.println("After join -> "+ thread.getState());

        System.out.println(" - End main thread - ");

    }
}
