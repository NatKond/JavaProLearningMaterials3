package org.tel.ran._2025_05_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class Tasks {
    public static void main(String[] args) {
        String str = "Hello";

        Function<String, String> function = (string) -> string.toUpperCase();
        System.out.println("function.apply(str) = " + function.apply(str));

        Supplier<String> supplier = () -> str.toUpperCase();
        System.out.println("supplier.get() = " + supplier.get());

        List<Student> students = Arrays.asList(
                new Student(1, "Alex"),
                new Student(2, "Oleg"),
                new Student(3, "Max")
        );

        System.out.println("getNames(students) = " + getNames(students));
    }

    private static List<String> getNames(List<Student> students) {
        List<String> names = new ArrayList<>();
        Function<Student, String> converter = (student) -> student.getName();
//        for (Student student : students) {
//            names.add(studentStringFunction.apply(student));
//        }

        students.forEach(student -> names.add(converter.apply(student)));
        return names;
    }
}
