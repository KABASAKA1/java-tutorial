package com.java_javafx_tutorial.genericsTypes.GenericStack;

public class GenericDemo {
    public static void main(String[] args) {
        GenericStack<Integer> ints = new GenericStack<>();
        ints.push(10);
        ints.push(20);
        ints.push(30);
        ints.push(40);
        System.out.println(ints.peek());
        System.out.println(ints.pop());
        System.out.println(ints.peek());
    }
}
