package com.java_javafx_tutorial.collections;

public class TreeMapMain<K extends Comparable<K>, V> {
    private TreeNode<K,V> root;
    private int size;
    public TreeMapMain() {
        root = null;
        size = 0;
    }
    public V put(K key, V value) {
        if (root == null) {
            root = new TreeNode<K,V>(key, value);
            size++;
            return null;
        }else {
            return putRecursive(root , key,value);
        }
    }
    private V putRecursive(TreeNode<K,V> node, K key, V value) {
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            if (node.left == null) {
                node.left = new TreeNode<K,V>(key, value);
                size++;
                return null;
            }else {
                return putRecursive(node.left, key, value);
            }
        }else if (compare > 0) {
            if (node.right == null) {
                node.right = new TreeNode<K,V>(key, value);
                size++;
                return null;
            }else
                return putRecursive(node.right, key, value);
        }else{  //value'nun bulunduğu düğüme gelince onun değerini değiştirme
            V oldValue = node.value;
            node.value = value;
            return oldValue;
        }
    }
    public V get(K key) {
        return getRecursive(root,key);
    }
    private V getRecursive(TreeNode<K,V> node, K key) {
        if (node==null)
            return null;
        int compare = key.compareTo(node.key);
        if (compare < 0) {
            return getRecursive(node.left, key);
        }else if (compare > 0) {
            return getRecursive(node.right, key);
        }else {
            return node.value;
        }
    }
}
class TreeNode<K,V> {
    K key;
    V value;
    TreeNode<K,V> left;
    TreeNode<K,V> right;
    public TreeNode(K key, V value) {
        this.key = key;
        this.value = value;
        left = null;
        right = null;
    }
}
