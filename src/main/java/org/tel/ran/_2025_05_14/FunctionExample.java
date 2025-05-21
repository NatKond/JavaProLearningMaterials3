package org.tel.ran._2025_05_14;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        Function<Integer, Double> half = a -> a / 2.0;
        Double result = half.apply(7);
        System.out.println("Half of 7 is " + result);

        Function<String, String> modify = text -> text.toUpperCase();
        String hello = modify.apply("hello");
        System.out.println(hello);
    }
}
