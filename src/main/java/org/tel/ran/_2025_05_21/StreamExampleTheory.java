package org.tel.ran._2025_05_21;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamExampleTheory {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("10", "20", "30", "1", "15", "20", "50");
        int count1 = 0;
        Predicate<String> check20 = (s -> "20".equals(s));

        for (String s : list) {
            if (check20.test(s)){
                count1++;
            }
        }
        System.out.println("count1 = " + count1);

        long count2 = list.stream()
                .filter(check20)
                .count();

        System.out.println("count2 = " + count2);

        var ref = new Object() {
            int count = 0;
        };
        list.forEach(s -> {
            if (check20.test(s)) {
                ref.count++;
            }
        });
        System.out.println("ref.count = " + ref.count);
    }
}
