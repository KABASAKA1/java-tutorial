package com.java_javafx_tutorial.collections.iterable;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyList<T> implements Iterable<T> {
    private T[] items;
    private int size;
    public MyList(int capacity) {
        this.size = 0;
        items = (T[]) new Object[capacity];
    }
    public void add(T item) {
        if (size == items.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        items[size++] = item;
    }
    public T get(int index) {
        return items[index];
    }
    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyListIterator();
    }
    //MyListIterator iç sınıfı tanımlanması
    private class MyListIterator implements Iterator<T> {
        private int currentIndex;
        @Override
        public boolean hasNext() {
            return currentIndex < size;
        }
        @Override
        public T next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return items[currentIndex++];
        }
        @Override
        public void remove() {
            Iterator.super.remove();
        }
    }
}
class Main{
    public static void main(String[] args) {
        MyList<String> myList = new MyList<>(10);
        myList.add("Alice");
        myList.add("Bob");
        myList.add("Charlie");
        myList.add("David");
        myList.add("Eve");
        myList.add("Fred");
        //listeyi görüntüleme
        for (String name : myList)
            System.out.println(name);
        // foreach yerine iterator kullanarak dolaşma
        Iterator<String> iterator= myList.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
