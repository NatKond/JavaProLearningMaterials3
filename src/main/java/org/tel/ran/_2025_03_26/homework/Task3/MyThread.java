package org.tel.ran._2025_03_26.homework.Task3;

public class MyThread extends Thread {

    private long start;
    private long end;
    private int number;
    private int count = 0;

    public MyThread(long start, long end, int number) {
        this.start = start;
        this.end = end;
        this.number = number;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        for (long i = start; i <= end; i++) {
            if (i % number == 0) {
                count++;
            }
        }
        System.out.println(Thread.currentThread().getName() + ": start = " + start + "; end = " + end + "; count = " + count);
    }
}
