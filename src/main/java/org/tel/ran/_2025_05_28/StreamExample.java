package org.tel.ran._2025_05_28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(4, 6, 4, 2, 6, 7, 8, 3, 1, 3));
        System.out.println(integers);

        System.out.println(integers.stream().sorted().toList());

        ArrayList<Integer> collected = integers.stream()
                .sorted((a, b) -> b - a)
                .skip(3)
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        var ref = new Object() {
            int count = 0;
        };

        System.out.println(integers.stream().filter(integer -> ref.count++ < (integers.size() - 3)).toList());
        System.out.println("ref.count = " + ref.count);

        System.out.println(integers.stream()
                .distinct()
                .collect(Collectors.toList()));

        System.out.println("max = " + integers.stream().max((a, b) -> a - b).orElse(-1));

        ArrayList<Integer> list = new ArrayList<>();
        // System.out.println(list.stream().max((a, b) -> a - b).get()); - exception
        System.out.println(list.stream().max(Comparator.comparingInt(i -> i)).orElse(-1));

        System.out.println(integers
                .stream()
                .max(Comparator.comparingInt(i -> i))
                .orElse(-1));

        System.out.println(integers
                .stream()
                .min(Comparator.comparingInt(i -> i))
                .orElse(-1));

        integers.stream()
                .filter(i -> i > 5)
                .findAny()
                .ifPresent(i -> System.out.println("int = " + i));

        integers.stream()
                .filter(i -> i > 10)
                .findAny()
                .ifPresentOrElse(i -> System.out.println("int = " + i), () -> System.out.println("No value"));

        Stream.of(1, 5, 6, 4, 3, 6);

        Arrays.asList("Hello", "java" , "word");

    }
}
