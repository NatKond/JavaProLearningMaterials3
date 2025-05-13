package org.tel.ran._2025_04_30;

import java.util.HashMap;
import java.util.Map;

public class GCExample {

    private int count = 0;

    private int[] array = new int[1000000];

    // -Xms100M - минимальный размер кучи
    // -Xmx100M - максимальный размер кучи
    // -XX:+PrintGCDetails - напечатать подрубную информацию о рспеределении памяти


    public GCExample(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        Map<Integer, GCExample> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            // map.put(i, new GCExample(i));
            new GCExample(i);
        }
    }

    @Override
    protected void finalize() throws Throwable {
        // System.out.println("Object collected by GC " + count);
        super.finalize();
    }
}
