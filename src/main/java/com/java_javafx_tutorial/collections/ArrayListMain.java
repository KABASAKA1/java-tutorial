package com.java_javafx_tutorial.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListMain {

    public static void main(String[] args) {
        // ArrayList oluşturma
        ArrayList<String> fruits = new ArrayList<>();
        // ArrayList'e eleman ekleme
        fruits.add("Elma");
        fruits.add("Armut");
        fruits.add("Muz");
        // ArrayList'i yazdırma
        System.out.println(fruits);
        // Belirli bir elemanı alma
        String firstFruit = fruits.get(0);
        System.out.println("İlk meyve: " + firstFruit);
        // Belirli bir elemanı güncelleme
        fruits.set(1, "Çilek");
        // Belirli bir elemanı silme
        fruits.remove(0);
        // ArrayList'in boyutunu alma
        int size = fruits.size();
        // Belirli bir elemanın var olup olmadığını kontrol etme
        boolean hasApple = fruits.contains("Elma");
        // Tüm elemanları temizleme
        fruits.clear();

        // For-each döngüsü ile gezinme
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
        // Iterator ile gezinme
        Iterator<String> iterator = fruits.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


    }
}
