package com.java_javafx_tutorial.genericsTypes.generic_deneme;

public class GenericsTanimlama<K,V> {
    private K key;
    private V value;
    public GenericsTanimlama(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
