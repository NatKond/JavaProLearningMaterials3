package org.tel.ran._2025_03_26;

public class RunnableTask extends Object implements Runnable{

    private int start;
    private int end;
    private int div;
    private int count;

    public RunnableTask(int start, int end, int div) {
        this.start = start;
        this.end = end;
        this.div = div;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();

        for (int i = start; i <= end; i++) {
            if (i % div == 0) {
                count++;
            }
        }

        System.out.println(Thread.currentThread().getName() + "-> количество (Runnable) = " + count);
        System.out.println(Thread.currentThread().getName() + "-> время выполнения = " + (System.currentTimeMillis() - currentTime));
    }
}
