package org.tel.ran._2025_04_01.sync.outer;

public class Account {
    private int sum;

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void plusSum(int val) {
        this.sum += val;
    }

    public void minusSum(int val) {
        this.sum -= val;
    }
}
