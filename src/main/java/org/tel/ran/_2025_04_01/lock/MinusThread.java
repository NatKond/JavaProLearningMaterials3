package org.tel.ran._2025_04_01.lock;

import java.util.concurrent.locks.Lock;

import static org.tel.ran.textFormatting.RED;

public class MinusThread extends Thread {
    private Account account;
    private int sum;
    private Lock lock;

    public MinusThread(Account account, int sum, Lock lock) {
        this.account = account;
        this.sum = sum;
        this.lock = lock;
    }



    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            lock.lock();
            account.minusSum(sum);
            lock.unlock();
        }

    }
}
