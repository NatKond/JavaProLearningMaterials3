package org.tel.ran._2025_05_26;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CatsApp {
    public static void main(String[] args) {
        List<Cat> cats = Arrays.asList(
                new Cat("Fluffy", 15),
                new Cat("Friendly", 20),
                new Cat("Mrs Noris", 5),
                new Cat("Sam", 7)
        );

        System.out.println(filterCatsByName('F',cats));
        System.out.println(filterCatsByAge(10, cats));

    }

    public static List<Cat> filterCatsByName(Character c, List<Cat> cats) {
        return cats.stream()
                .filter((cat) -> cat.getName().charAt(0) == c)
                .collect(Collectors.toList());
    }

    public static List<Cat> filterCatsByAge(Integer age, List<Cat> cats) {
        return cats.stream()
                .filter((cat) -> cat.getAge() < age)
                .peek(cat -> cat.setAge(cat.getAge() + 1))
                .collect(Collectors.toList());
    }
}
