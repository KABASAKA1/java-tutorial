package com.java_javafx_tutorial.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MySet<T> implements Iterable<T> {
    private ArrayList<T> elements;
    public MySet() {
        elements = new ArrayList<>();
    }
    //eleman ekleme
    public boolean add(T element) {
        if (!elements.contains(element)) {
            elements.add(element);
            return true;
        }
        return false;
    }
    //eleman çıkarma
    public boolean remove(T element) {
        return elements.remove(element);
    }
    //elemanı içeriyormu?
    public boolean contains(T element) {
        return elements.contains(element);
    }
    //eleman sayısı
    public int size() {
        return elements.size();
    }
    //set boşmu?
    public boolean isEmpty() {
        return elements.isEmpty();
    }
    @Override
    public Iterator<T> iterator() {
        return new MySetIterator();
    }

    //iç iterator sınıfı
    class MySetIterator implements Iterator<T> {
        private int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < elements.size();
        }
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return elements.get(currentIndex++);
        }

        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }


    public static void main(String[] args) {
        MySet<String> set = new MySet<String>();
        set.add("Alice");
        set.add("Bob");
        set.add("Carl");
        set.add("Dan");
        set.add("Eve");
        set.add("Dan"); //Dan tekrar eklenmez
        Iterator<String> it = set.iterator();
        //elemanlarını yazdırma
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

