package com.java_javafx_tutorial.genericsTypes.generic_deneme;

import java.time.LocalDate;

public class GenericDemo {
    public static void main(String[] args) {
        GenericsTanimlama<String, LocalDate> today = new GenericsTanimlama<>("today", LocalDate.now());
        GenericsTanimlama<Integer,String> kayseri = new GenericsTanimlama<>(38,"Kayseri");
        System.out.println(today.getKey()+" "+today.getValue());
        System.out.println(kayseri.getKey()+" "+kayseri.getValue());
    }
}
