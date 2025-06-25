package org.tel.ran._2025_05_15;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionExample {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        String s = new String("HELLO");
        Class<? extends String> clazz = s.getClass();

        System.out.println("class = " + clazz.getName());
        System.out.println("class (simple name) = " + clazz.getSimpleName());

        Constructor<? extends String> constructor = clazz.getConstructor();
        System.out.println("class =" + constructor);

        System.out.println("-".repeat(20) + "Constructors" + "-".repeat(20));
        Constructor<?>[] constructors = clazz.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        System.out.println("-".repeat(20) + "Declared Constructors" + "-".repeat(20));
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);

        System.out.println("-".repeat(20) + "Methods" + "-".repeat(20));
        Method[] methods = clazz.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        System.out.println("-".repeat(20) + "Declared Methods" + "-".repeat(20));
        Method[] declaredMethods = clazz.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);

        System.out.println("-".repeat(20) + "Get Method" + "-".repeat(20));
        Method toLowerCase = clazz.getMethod("toLowerCase");
        toLowerCase.invoke(s);
        System.out.println(s);
    }
}
