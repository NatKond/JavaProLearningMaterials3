package org.tel.ran._2025_05_14;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConsumerExample {
    public static void main(String[] args) {
        Map<String, Integer> stringIntegerMap = new HashMap<>(Map.of("Jane", 1, "Bob", 2, "John", 2));
        stringIntegerMap.forEach((k,v)-> System.out.println("Key : " + k + ", value : " + v));
    }
}
