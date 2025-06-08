package org.tel.ran._2025_03_26;

import static org.tel.ran.textFormatting.*;

public class MainThread {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(YELLOW + "=".repeat(5) + " НАЧАЛО РАБОТЫ ГЛАВНОГО ПОТОКА " + "=".repeat(5));
        // Без многопоточности
        // getCountDiv(0, Integer.MAX_VALUE / 2, 13);
        getCountDiv(0, 1_000_000_000, 13);

        // Многопоточно (используем Thread)
        System.out.println(YELLOW + "=".repeat(5) + " THREADS " + "=".repeat(5) + RESET);
        ThreadTask task1 = new ThreadTask(0, 500_000_000, 13);
        ThreadTask task2 = new ThreadTask(500_000_001, 1_000_000_000, 13);

        long currentTime = System.currentTimeMillis();
        task1.start();
        task2.start();
        // заставляем главный поток ждать завершения дочерних
        task1.join();
        task2.join();

        System.out.println("Общее количество (multi): " + (task1.getCount() + task2.getCount()));
        System.out.println("Общее время выполнения (Thread): " + (System.currentTimeMillis() - currentTime));

        // Используем также главный поток для работы
        System.out.println(YELLOW + "=".repeat(5) + " THREAD AND MAIN " + "=".repeat(5) + RESET);
        currentTime = System.currentTimeMillis();
        ThreadTask task3 = new ThreadTask(0, 500_000_000, 13);
        task3.start();
        int count = getCountDiv(500_000_001, 1_000_000_000, 13);
        task3.join(); // ожидаем завершение дочернего потока
        System.out.println("Общее количество (multi): " + (task3.getCount() + count));
        System.out.println("Общее время выполнения (Thread): " + (System.currentTimeMillis() - currentTime));

        // Многопоточно (используем Runnable)
        System.out.println(YELLOW + "=".repeat(5) + " RUNNABLE " + "=".repeat(5) + RESET);
        currentTime = System.currentTimeMillis();
        RunnableTask runTask1 = new RunnableTask(0, 500_000_000, 13);
        RunnableTask runTask2 = new RunnableTask(500_000_001, 1_000_000_000, 13);
        Thread th1 = new Thread(runTask1, "Task1");
        Thread th2 = new Thread(runTask2, "MainShop");
        th1.start();
        th2.start();
        // заставляем главный поток ждать завершения дочерних
        th1.join();
        th2.join();
        System.out.println("Общее количество (multi): " + (runTask1.getCount() + runTask2.getCount()));
        System.out.println("Общее время выполнения (Thread): " + (System.currentTimeMillis() - currentTime));

        // Нельзя использовать в новых программах
        // th1.stop(); // останавливает дочерний поток, но некорректно
        // th1.suspend(); // приостанавливает выполнение дочернего потока
        // th1.resume(); // запускает ранее приостановленный suspend() дочерний поток

        System.out.println(YELLOW + "=".repeat(5) + " КОНЕЦ РАБОТЫ ГЛАВНОГО ПОТОКА " + "=".repeat(5));
    }

    private static int getCountDiv(int start, int end, int div) {
        long currentTime = System.currentTimeMillis();

        int count = 0;
        for (int i = start; i <= end; i++) {
            if (i % div == 0) {
                count++;
            }
        }

        System.out.println("Количество = " + count);
        System.out.println("Время выполнения = " + (System.currentTimeMillis() - currentTime));
        return count;
    }
}
