package com.java_javafx_tutorial.genericsTypes.bounded_generic_type;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //üst sınır Number olan Box sınıfının kullanımı
        Box<Integer> intBox = new Box<Integer>(23);
        Box<Double> doubleBox = new Box<Double>(3.14);

        List<Number> numbers = new ArrayList<>();
        numbers.add(34);
        numbers.add(45);
        numbers.add(56);
        //alt sınırı Integer olan bir listeyi yazdırmak için Printer sınıfı kullanımı
        Printer.printList(numbers);
    }
}

class Box<T extends Number> {
    private T value;
    public Box(T value) {
        this.value = value;
    }
    public T getValue() {
        return value;
    }
    public void setValue(T value) {
        this.value = value;
    }
}

class Printer{
    public static <T> void printList(List< ? super T> list){
        for (Object o : list) {
            System.out.println(o + " ");
        }
        System.out.println();
    }
}