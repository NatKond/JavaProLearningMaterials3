package org.tel.ran._2025_04_01.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class MinusThread extends Thread {
    private AtomicInteger account;
    private int sum;
    private AtomicInteger counter;

    public MinusThread(AtomicInteger account, int sum, AtomicInteger counter) {
        this.account = account;
        this.sum = sum;
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            account.addAndGet(-sum);

            counter.incrementAndGet();  // учитываю эту операцию в счетчике
        }

    }
}
