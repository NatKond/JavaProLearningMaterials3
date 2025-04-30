package org.tel.ran._2025_04_30.mainClass;

public class GCExample {

    private int count = 0;

    private int[] array = new int[1000000];

    public GCExample(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 1000000; i++) {
            new GCExample(i);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object collected by GC " + count);
        super.finalize();
    }
}
