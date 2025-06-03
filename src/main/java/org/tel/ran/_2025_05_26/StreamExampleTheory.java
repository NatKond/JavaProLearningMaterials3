package org.tel.ran._2025_05_26;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Stream - поток данных
 * stream() - создание потока данных у коллекции
 * что бы мы ни делали в стриме, оригинальная коллекция не изменится
 *
 * Intermediate (промежуточная операция, конвеерная) их может быть много , они идут
 * в стриме друг за другом через "." и каждая такая операция принимает
 * стрим и возвращает после себя тоже стрим, количество таких команд не ограничено
 *
 * Terminal - конечная операция, которая возвращает или делает какой-то результат, она
 * может быть только одна, после нее стрим завершен
 * Без этой терминальной операции стрим не выполнится вообще, никакая комана стрима
 * без терминальной операции не начнет выполнятся
 *
 * collection.stream().Intermediate.Intermediate........Intermediate.Terminal;
 *
 * Intermediate :
 * filter(predicate) - фильтрует элементы стрима
 *
 * Terminal :
 * int count() - возвращает количество элементов в стриме
 * void foreach(consumer) - применить какое-либо действие ко всем элементам нашего стрима
 */
public class StreamExampleTheory {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("10","20","30","1","15","20","50");
        System.out.println(list.size());
        long count = list.stream().count();
        System.out.println("Count = " + count);
        //"20"
        int counter = 0;
        for(String str : list) {
            if("20".equals(str)) {
                counter++;
            }
        }
        System.out.println("Count of 20 is " + counter);

        Predicate<String> check20 = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return "20".equals(s);
            }
        };

        Predicate<String> check20asLambda = (s) ->"20".equals(s);

        count = 0;
        for(String str : list) {
            if(check20asLambda.test(str)) {
                counter++;
            }
        }


        //filter
        //"10","20","30","1","15","20","50"                      "20" , "20"
        //<data stream> ->                .filter(predicate). -> <data stream>
        long count1 = list
                .stream()
                .filter(check20asLambda)
                .count();
        System.out.println("Count of 20 is " + count1);

        //foreach - терминальный оператор
        Consumer<String> printer = (s) -> System.out.print(" " + s);
        list.stream()
                .filter(check20asLambda)
                .forEach(printer);

        System.out.println();

        list.stream()
                .filter(s -> "20".equals(s))
                .forEach(s -> {
                    System.out.println("Element");
                    System.out.print(" "+ s);
                });
    }
}
