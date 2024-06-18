package com.java_javafx_tutorial.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionMain {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add("Pear");
        fruits.add("Grape");
        fruits.add("Pineapple");
        //bir lsiteyi doğal sırasına göre sıralar
        Collections.sort(fruits);
        //bir listedeki elemanların sırasını tersine çevirir
        Collections.reverse(fruits);
        //bir listedeki elemanları karıştırmak için kullanılır
        Collections.shuffle(fruits);
        //sıralanmış bir listedeki belirtilen anahtarın indeksini geri döner
        Collections.sort(fruits);
        int index = Collections.binarySearch(fruits, "Pear");
        //bir listedeki en büyük ve en küçük elemanı geri döner
        String max = Collections.max(fruits);
        String min = Collections.min(fruits);
        //bir listede belirtilen değeri kullanarak tüm elemanları doldurur
        Collections.fill(fruits, "değer");
        //bir listedeki tüm elemanları başka bir listeye kopyalar.
        //Hedef listenin boyutu, kaynak listeyle aynı veya daha büyük olmalıdır.
        List<String> fruitsCopy = new ArrayList<>(Collections.nCopies(fruits.size(), null)); //burada hedef listeyi oluşturup içini boş olarak doldurmalıyımki copy() methodunu kullanabileyim
        Collections.copy(fruitsCopy,fruits);
        //belirtilen elemanın belirtilen sayıda kopyasından oluşturup o listeyi dönme
        List<String> copiedList = Collections.nCopies(5, "kopyalanacak değer");
        //bir listedeki iki elemanın yerini değiştirme
        Collections.swap(fruits,0,4);
    }
}
