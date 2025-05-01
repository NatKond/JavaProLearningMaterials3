package org.tel.ran._2025_04_01.lock;

import java.util.concurrent.locks.Lock;

import static org.tel.ran.textFormatting.GREEN;

public class PlusThread extends Thread{
    private Account account;
    private int sum;
    private Lock lock;
    private Account accountTax;
    private Lock lockTax;

    public PlusThread(Account account, int sum, Lock lock, Account accountTax, Lock lockTax) {
        this.account = account;
        this.sum = sum;
        this.lock = lock;
        this.accountTax = accountTax;
        this.lockTax = lockTax;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            lock.lock();
            account.plusSum(sum);
            lock.unlock();

            lockTax.lock();
            accountTax.plusSum((int)(sum * 0.1));
            lockTax.unlock();
        }


    }
}
