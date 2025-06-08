package org.tel.ran._2025_04_11;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class MainScheduled {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1); //размер пула
        executorService.scheduleAtFixedRate(new TaskShedule(), 0, 5, TimeUnit.SECONDS); // повторять

    }
}

class TaskShedule implements Runnable {
    @Override
    public void run() {
        System.out.println("Проверяем почту..."+Thread.currentThread().getName());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
