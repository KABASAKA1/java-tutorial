package com.java_javafx_tutorial.genericsTypes.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(2,4,6,7,7);
        printList(list);

        sumOfList(list);

        List<Number> numbers = new ArrayList<>();
        addNumbers(numbers);    // addNumber() methoduna List.of() methodu ile oluşturlan list gönderilemez
        printList(numbers);


    }

    //bu unbounded wildcard'dır. Burada herhangi bir türden list'i kabul eder
    public static void printList(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }

    //bu upper bounded wildcard'dır . Burada belirtilen class'dan veya altsınıflarından kabul eder .
    //Bu genellikle yalnızca okuma amacıyla kullanılan generic colectionlarda kullanılır
    public static void sumOfList(List<? extends Number> list) {
        double sum = 0;
        for (Number number : list) {
            sum += number.doubleValue();
        }
        System.out.println(sum);
    }

    //bu lower bounded wildcard'dır. Bu belirtilen class veya üst classlarının kabul eder
    //bu genellikle yazma amacıyla kullanılan generic colection'lar için kullanılır
    public static void addNumbers(List<? super Integer> list) {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
    }
}
