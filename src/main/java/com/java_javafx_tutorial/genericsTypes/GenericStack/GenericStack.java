package com.java_javafx_tutorial.genericsTypes.GenericStack;

import java.util.ArrayList;

public class GenericStack<E>{
    private ArrayList<E> list = new ArrayList<>();

    public void push(E e){
        list.add(e);
    }
    public E pop(){
        return list.remove(list.size()-1);
    }
    public E peek(){
        return list.get(list.size()-1);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public int size(){
        return list.size();
    }
}
