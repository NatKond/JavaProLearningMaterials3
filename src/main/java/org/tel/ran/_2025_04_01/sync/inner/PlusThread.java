package org.tel.ran._2025_04_01.sync.inner;

import static org.tel.ran.textFormatting.GREEN;

public class PlusThread extends Thread{
    private Account account;
    private int sum;

    public PlusThread(Account account, int sum) {
        this.account = account;
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {
            account.plusSum(sum);
            System.out.print(GREEN);
        }
    }
}
