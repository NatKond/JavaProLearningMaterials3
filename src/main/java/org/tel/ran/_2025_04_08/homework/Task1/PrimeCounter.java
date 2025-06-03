package org.tel.ran._2025_04_08.homework.Task1;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class PrimeCounter implements Callable<Integer> {

    private int start;
    private int end;
    @Getter
    private List<Integer> primeList;

    public PrimeCounter(int start, int end) {
        this.start = start;
        this.end = end;
        primeList = new ArrayList<>();
    }

    @Override
    public Integer call() throws Exception {
        if (start < 0 || end < 0){
            throw new IllegalArgumentException("End or start number could not be negative");
        }

        int count = 0;

        for (int i = start; i < end; i++) {
            if (primeCheck(i)){
                primeList.add(i);
                count++;
            }
        }

        return count;
    }

    private boolean primeCheck(int number) {
        if (number == 1 || (number % 2) == 0) {
            return false;
        }
        for (int i = 3; i < Math.sqrt(number); i += 2) {
            if (number % i == 0){
                return false;
            }
        }
        return true;
    }
}
