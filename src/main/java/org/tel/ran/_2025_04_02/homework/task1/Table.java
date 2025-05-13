package org.tel.ran._2025_04_02.homework.task1;

import static org.tel.ran.textFormatting.GREEN;
import static org.tel.ran.textFormatting.RED;

public class Table {

    private boolean isEmpty = true;

    public void put(int count) {
        System.out.println(GREEN + Thread.currentThread().getName() + " puts the " + count + " part on the table");
        isEmpty = false;
    }

    public void get(int count) {
        System.out.println(RED + Thread.currentThread().getName() + " takes the " + count + " part from the table");
        isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }
}
