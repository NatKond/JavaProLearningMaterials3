package org.tel.ran._2025_04_01.sync.outer;

public class MinusThread extends Thread{
    private Account account;
    private int sum;

    public MinusThread(Account account, int sum) {
        this.account = account;
        this.sum = sum;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100_000; i++) {

            synchronized (account) { //синхронизировать доступ к объекту account, используя его монитор (внешняя синхронизаця)
                account.minusSum(sum);
                // какие то другие команды
            }

        }

    }
}
