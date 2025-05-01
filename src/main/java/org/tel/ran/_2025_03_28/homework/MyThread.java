package org.tel.ran._2025_03_28.homework;

import static org.tel.ran.textFormatting.RED;
import static org.tel.ran.textFormatting.YELLOW;

public class MyThread extends Thread {
    private int start;
    private int end;
    private int count;

    public MyThread(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();

        for (int i = start; i < end; i++) {
            if (Thread.interrupted()){
                System.out.println(YELLOW + Thread.currentThread().getName() + "Execution time : " + (System.currentTimeMillis() - currentTime));
                System.out.println("Prime numbers count = " + count);
                return;
            }
            boolean isPrime = true;
            if (i % 2 == 0) {
                continue;
            }
            for (int j = 3; j * j < i; j += 2) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime){
                System.out.println(i);
                count++;
            }

        }
    }
}
