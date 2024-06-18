package com.java_javafx_tutorial.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListMain {
    public static void main(String[] args) {

        List<String> sehirler = new ArrayList<>();
        sehirler.add("Ankara");
        sehirler.add("Istanbul");
        sehirler.add("Izmir");
        sehirler.add("Kayseri");
        //listeyi yazdırma
        System.out.println(sehirler);
        //belirli bir indisteki elemanı güncelleme
        sehirler.set(2,"Bursa");
        //belirli bir indisteki elemanı alma
        System.out.println(sehirler.get(3));
        //listedeki elemanı silme
        sehirler.remove(1);
        //liste boyutunu alma
        int size = sehirler.size();
        //listenin boş olup olmadığını kontrol etme
        boolean isEmpty = sehirler.isEmpty();
        //listenin belirtilen öğeyi içerip içermediğimi kontrol eder
        boolean contains = sehirler.contains("Bursa");
        //listedeki tüm elemanları siler
        sehirler.clear();


        // ITERATOR KULLANIMI

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Grape");
        //listeden iterator nesnesini alma
        ListIterator<String> iterator = fruits.listIterator();  //daha etkili ve kapsamlı kullanım için Iterator yerine ListIterator kullanın
        //iterator ile nesne üzerinde gezinme
        while (iterator.hasNext()) {    //ileri doğru gezinme
            System.out.println(iterator.next());
        }
        while (iterator.hasPrevious()) {    //geriye doğru gezinme
            System.out.println(iterator.previous());
        }
        //iterator nesnesinin olduğu indise ekleme yapar
        iterator.add("Peach");
        //iterator nesnesinin olduğu nesneyi  günceller
        //iterator.set("Vegetables");  //burada set() methodunu kullanmanız için next() veya previous() ile bir yere gelmeniz gerekiyor ondan sonra kullanılabiliyo
        System.out.println(fruits);

    }

}
