package org.tel.ran._2025_04_02.homework.task1;

import java.util.Scanner;

public class Task1 {
    public static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        Integer numberOfParts = getNumberOfParts();

        Table table = new Table();
        Robot robotGet = new Robot(Action.GET,table);
        Robot robotPut = new Robot(Action.PUT,table);

        robotGet.setNumberOfParts(numberOfParts);
        robotPut.setNumberOfParts(numberOfParts);

        Thread robotGetThread = new Thread(robotGet, "RobotGet");
        Thread robotPutThread = new Thread(robotPut, "RobotPut");

        robotGetThread.start();
        robotPutThread.start();
    }

    private static int getNumberOfParts() {
        System.out.println("Enter the number of parts");
        return SCANNER.nextInt();
    }


}
