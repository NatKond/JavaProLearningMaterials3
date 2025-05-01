package org.tel.ran._2025_04_01.sync.outer;


public class MainSync {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        Thread father = new PlusThread(account ,10);
        Thread child = new MinusThread(account ,10);

        System.out.println("До = " + account.getSum());

        father.start();
        child.start();

        father.join();
        child.join();

        System.out.println("После = " + account.getSum());
    }
}
