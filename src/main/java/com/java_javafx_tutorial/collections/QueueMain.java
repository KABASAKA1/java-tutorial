package com.java_javafx_tutorial.collections;

import java.util.NoSuchElementException;

public class QueueMain<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;
    public QueueMain() {
        front = null;
        rear = null;
        size = 0;
    }
    public void enqueue(T value) {
        Node<T> newNode = new Node<T>(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        }else {
            rear.setNext(newNode);
            rear = newNode;
        }
        size ++;
    }
    public T dequeue() {
        if (front == null) {
            throw new NoSuchElementException();
        }else {
            T data = front.getData();
            front = front.getNext();
            if (front == null) {
                rear = null;
            }
            size--;
            return data;
        }
    }
    public T peek() {
        if (front == null) {
            throw new NoSuchElementException();
        }else {
            return front.getData();
        }
    }
    public boolean isEmpty() {
        return front == null;
    }
    public int size() {
        return size;
    }
}

class Node<T>{
    private T data;
    private Node<T> next;
    public Node(T data) {
        this.data = data;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}
class Main{
    public static void main(String[] args) {
        QueueMain<String> queue = new QueueMain<>();
        //kuyruğa eleman ekleme
        queue.enqueue("Alice");
        queue.enqueue("Bob");
        queue.enqueue("Charlie");
        queue.enqueue("David");
        //kuyuğun önündeki elemanı döndür ve çıkar
        System.out.println(queue.dequeue());
        //kuyruğun önğndeki elemanı döndür
        System.out.println(queue.peek());
        //kuyruğa yeni eleman ekleme
        queue.enqueue("Ahmet");
        //kuyruğun tüm elemanlarını çıkar ve yazdır
        while (!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}