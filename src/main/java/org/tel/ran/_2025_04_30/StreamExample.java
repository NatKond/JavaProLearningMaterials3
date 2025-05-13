package org.tel.ran._2025_04_30;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) {
//        int i = 0;
//        Map<Integer, String> fruitMap =  Stream.of("Apple", "Pineapple", "Orange", "Kiwi", "Banana", "Grape", "Mango", "Plum", "Pear", "Cherry", "Lime", "Peach").sorted()
//                .collect(Collectors.toMap(s -> i++, s -> s,(oldValue, newValue) -> newValue, TreeMap::new));

        AtomicInteger n = new AtomicInteger();
        Map<Integer, String> fruitMap1 =  Stream.of("Apple", "Pineapple", "Orange", "Kiwi", "Banana", "Grape", "Mango", "Plum", "Pear", "Cherry", "Lime", "Peach").sorted()
                .collect(Collectors.toMap(s -> n.getAndIncrement(), Function.identity(),(oldValue, newValue) -> newValue, TreeMap::new));

        System.out.println(fruitMap1);

        final int[] j = {0};
        Map<Integer, String> fruitMap2 =  Stream.of("Apple", "Pineapple", "Orange", "Kiwi", "Banana", "Grape", "Mango", "Plum", "Pear", "Cherry", "Lime", "Peach").sorted()
                .collect(Collectors.toMap(s -> j[0]++, Function.identity(),(oldValue, newValue) -> newValue, TreeMap::new));
        System.out.println(fruitMap2);

        var ref = new Object() {
            int k = 0;
        };

        Map<Integer, String> fruitMap3 =  Stream.of("Apple", "Pineapple", "Orange", "Kiwi", "Banana", "Grape", "Mango", "Plum", "Pear", "Cherry", "Lime", "Peach").sorted()
                .collect(Collectors.toMap(s -> ref.k++, Function.identity(),(oldValue, newValue) -> newValue, TreeMap::new));
        System.out.println(fruitMap3);
        System.out.println(ref.getClass().getName());
    }
}
