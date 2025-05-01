package org.tel.ran._2025_03_26;

import static org.tel.ran.textFormatting.RESET;
import static org.tel.ran.textFormatting.YELLOW;

public class MainDaemons {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(YELLOW + "=".repeat(5) + " НАЧАЛО РАБОТЫ ГЛАВНОГО ПОТОКА " + "=".repeat(5) + RESET);

        ThreadTask task1 = new ThreadTask(0, 500_000_000, 13, true);
        ThreadTask task2 = new ThreadTask(500_000_001, 1_000_000_000, 13, true);
        task1.setDaemon(true); // при завершении главного потока этот дочерний поток закрывается
        task2.setDaemon(true);
        task1.start();
        task2.start();

        Thread.sleep(1000); // приостанавливаю главный поток на 1 сек.

        System.out.println(YELLOW + "=".repeat(5) + " КОНЕЦ РАБОТЫ ГЛАВНОГО ПОТОКА " + "=".repeat(5));
    }
}
