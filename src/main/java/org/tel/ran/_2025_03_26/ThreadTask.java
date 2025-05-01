package org.tel.ran._2025_03_26;

public class ThreadTask extends Thread {

    private int start;
    private int end;
    private int div;
    private int count;
    private boolean show;

    public ThreadTask(int start, int end, int div) {
        this.start = start;
        this.end = end;
        this.div = div;
    }

    public ThreadTask(int start, int end, int div, boolean show) {
        this.start = start;
        this.end = end;
        this.div = div;
        this.show = show;
    }

    public int getCount() {
        return count;
    }


    @Override
    public void run() {
        long currentTime = System.currentTimeMillis();

        for (int i = start; i <= end; i++) {
            if (show) {
                System.out.println(Thread.currentThread().getName() + " число -> " + i);
            }
            if (i % div == 0) {
                count++;
            }
        }

        System.out.println(Thread.currentThread().getName() + "-> количество = (Thread)" + count);
        System.out.println(Thread.currentThread().getName() + "-> время выполнения = " + (System.currentTimeMillis() - currentTime));
    }
}

