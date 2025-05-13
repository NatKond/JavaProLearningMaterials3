package org.tel.ran._2025_04_02.ht;

public class MainRobot {
    public static void main(String[] args) {
        Desk desk = new Desk();

        RobotPut robotPut = new RobotPut(desk);
        RobotGet robotGet = new RobotGet(desk);

        new Thread(robotPut).start();
        new Thread(robotGet).start();
    }
}
