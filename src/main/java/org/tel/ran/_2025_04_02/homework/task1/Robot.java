package org.tel.ran._2025_04_02.homework.task1;

public class Robot implements Runnable {
    private Action action;
    private Table table;
    private Integer numberOfParts;

    public Robot(Action action, Table table) {
        this.action = action;
        this.table = table;
    }

    public void setNumberOfParts(Integer numberOfParts) {
        this.numberOfParts = numberOfParts;
    }

    @Override
    public void run() {
        if (action.equals(Action.PUT)) {
            putPart();
        } else if (action.equals(Action.GET)) {
            getPart();
        }
    }

    private void putPart() {
        for (int i = 0; i < numberOfParts; i++) {
            synchronized (table) {
                if (!table.isEmpty()) {
                    try {
                        table.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                table.put(i + 1);
                table.notify();
            }
        }
    }

    private void getPart() {
        for (int i = 0; i < numberOfParts; i++) {
            synchronized (table) {
                if (table.isEmpty()) {
                    try {
                        table.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                table.get(i + 1);
                table.notify();
            }
        }
    }
}
