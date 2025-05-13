package org.tel.ran._2025_04_02.ht;

public class RobotPut implements Runnable {
    private Desk desk;
    RobotPut(Desk desk){
        this.desk=desk;
    }

    public void run(){
        for (int i = 1; i < 10; i++) {
            try {
                desk.put();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
