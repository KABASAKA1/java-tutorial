package com.java_javafx_tutorial.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeSetMain <T extends Comparable<T>> implements Iterable<T> {
    private TreeSetNode<T> root;
    private int size;
    public TreeSetMain() {
        root = null;
        size = 0;
    }

    public boolean add(T t) {
        if (root == null) {
            root = new TreeSetNode<T>(t);
            size++;
            return true;
        }else {
            return addRecursive(root, t);
        }
    }
            private boolean addRecursive(TreeSetNode<T> node , T deger) {
                int cmp = deger.compareTo(node.deger);
                if (cmp <0) {
                    if (node.left == null) {
                        node.left = new TreeSetNode<T>(deger);
                        size++;
                        return true;
                    }else {
                        return addRecursive(node.left, deger);
                    }
                }else if (cmp > 0) {
                    if (node.right == null) {
                        node.right = new TreeSetNode<T>(deger);
                        size++;
                        return true;
                    }else {
                        return addRecursive(node.right, deger);
                    }
                }else {     // cmp = 0 durumudur yani değerin ağaçta olduğu durum
                    return false;
                }
            }
    public boolean contains(T deger) {
        return containsRecursive(root, deger);
    }
            private boolean containsRecursive(TreeSetNode<T> node , T deger) {
                if (node == null)
                    return false;
                int cmp = deger.compareTo(node.deger);
                if (cmp < 0) {
                    return containsRecursive(node.left, deger);
                }else if (cmp > 0) {
                    return containsRecursive(node.right, deger);
                }else {
                    return true;
                }
            }

    public int size() {
        return size;
    }
    @Override
    public Iterator<T> iterator() {
        return new MyTreeSetIterator();
    }
            class MyTreeSetIterator implements Iterator<T>{
                private TreeSetNode<T> next;
                MyTreeSetIterator() {
                    next = findMind(root);
                }
                        private TreeSetNode<T> findMind(TreeSetNode<T> node) {
                            while (node != null && node.left != null) {
                                node = node.left;
                            }
                            return node;
                        }
                @Override
                public boolean hasNext() {
                    return next != null;
                }
                @Override
                public T next() {
                    if (!hasNext()){
                        throw new NoSuchElementException();
                    }
                    TreeSetNode<T> current = next;
                    next = findNext(current);
                    return current.deger;
                }
                        private TreeSetNode<T> findNext(TreeSetNode<T> node) {
                            if (node.right != null) {
                                return findMind(node.right);
                            }else {
                                TreeSetNode<T> parent = root;
                                TreeSetNode<T> child = root;
                                while (child!= node){
                                    if (node.deger.compareTo(child.deger)<0){
                                        parent=child;
                                        child=child.left;
                                    }else {
                                        child=child.right;
                                    }
                                }
                                return parent.deger.compareTo(node.deger)>0 ? parent:null;
                            }
                        }
                @Override
                public void remove() {
                    Iterator.super.remove();
                }
            }
    public static void main(String[] args) {
        TreeSetMain<String> myTreeSet = new TreeSetMain<>();
        myTreeSet.add("Alice");
        myTreeSet.add("Ahmet");
        myTreeSet.add("Ibrahim");
        myTreeSet.add("Mahmut");
        myTreeSet.add("Baran");
        Iterator<String> iterator= myTreeSet.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
    }
}
class TreeSetNode<T> {
    T deger;
    TreeSetNode<T> left;
    TreeSetNode<T> right;
    public TreeSetNode(T deger) {
        this.deger = deger;
        left = null;
        right = null;
    }
}
