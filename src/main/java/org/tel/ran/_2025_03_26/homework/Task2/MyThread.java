package org.tel.ran._2025_03_26.homework.Task2;

public class MyThread extends Thread {

    private int start;
    private int end;
    private int number;
    private int sum;
    private int count;

    public MyThread(int start, int end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            if (i % number == 0) {
                sum += i;
                count++;
                if (count % 5 == 0) {
                    System.out.print(Thread.currentThread().getName() + " " + Thread.currentThread().isDaemon() + ": sum = " + sum + "\n");
                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " " + Thread.currentThread().isDaemon() + ": start = " + start + "; end = " + end + "; sum = " + sum);
    }
}
