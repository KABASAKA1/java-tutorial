package com.java_javafx_tutorial.genericsTypes.generic_method;

public class Main {
    public static void main(String[] args) {
        Integer[] sayilar = {2,3,4,5,6};
        swap(sayilar , 2,4);
        for (int sayi : sayilar) {
            System.out.println(sayi);
        }
    }


    public static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
