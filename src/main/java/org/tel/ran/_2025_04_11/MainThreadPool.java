package org.tel.ran._2025_04_11;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executor = Executors.newFixedThreadPool(5); //будет сразу создано и ограничен МАX количество потоков,
        //ExecutorService executor = Executors.newSingleThreadExecutor(); //всегда только один поток
        //ExecutorService executor = Executors.newCachedThreadPool(); //использует освободившиеся потоки, нет ограничения
        // ExecutorService executor = Executors.newWorkStealingPool(5); // 5 - максимальное число задач, которые могут выполняться параллельно.
        ExecutorService executor = Executors.newWorkStealingPool(); // один поток на каждый доступный процессор (CPU core).
        System.out.println("Доступное колличество ядер : " + Runtime.getRuntime().availableProcessors());
        for (int i = 0; i < 30; i++) {
            executor.execute(new Task(i+1));
            //Thread.sleep(100);
        }

        Thread.sleep(1000);
        executor.shutdown();
    }
}

class Task implements Runnable {
    int taskNumber;

    public Task(int taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100); // иммитируем работу
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Обработан запрос пользователя № %2d на потоке %s %n",taskNumber,Thread.currentThread().getName());
        //System.out.println("Обработан запрос пользователя №" + taskNumber + " на потоке " + Thread.currentThread().getName());
    }
}
