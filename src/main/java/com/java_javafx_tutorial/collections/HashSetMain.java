package com.java_javafx_tutorial.collections;

import java.util.LinkedList;

public class HashSetMain<T> {
    private final int size = 16;
    private LinkedList<HashNode<T>>[] table;
    public HashSetMain() {
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }
    private int getHash(T key) {
        return key.hashCode()  % size;
    }
    public void add(T deger) {
        int hash = getHash(deger);
        for (HashNode<T> node : table[hash]) {
            if (node.deger.equals(deger)) {
                return; //deger zaten ekli demek
            }
        }
        table[hash].add(new HashNode<>(deger));
    }
    public boolean contains(T deger) {
        int hash = getHash(deger);
        for (HashNode<T> node : table[hash]) {
            if (node.deger.equals(deger)) {
                return true;
            }
        }
        return false;
    }
    public boolean remove(T deger) {
        int hash = getHash(deger);
        for (HashNode<T> node : table[hash]) {
            if (node.deger.equals(deger)) {
                table[hash].remove(node);
                return true;
            }
        }
        return false;
    }
    public int size() {
        return table.length;
    }
}
class HashNode<T> {
    T deger;
    HashNode<T> next;
    public HashNode(T deger) {
        this.deger = deger;
        next = null;
    }
}