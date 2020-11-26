/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day4;

import java.util.HashMap;
import java.util.Map;

/**
 * 实现一个 LRU 缓存淘汰算法
 *
 * @author xingye
 * @created 2020/11/25
 */
public class MyLru<K, V> {
    private static class Node<K, V> {
        private K key;
        private V val;
        private Node<K, V> pre;
        private Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node<K, V> head;
    private Node<K, V> tail;
    private int size;
    private Map<K, Node<K, V>> keyAndNodeMap = new HashMap<>();

    public MyLru(int size) {
        this.size = size;
    }

    public void set(K key, V val) {
        // 检查是否重复
        Node<K, V> hasStore = keyAndNodeMap.get(key);
        if (null != hasStore) {
            // 直接覆盖
            hasStore.val = val;
            addToHead(hasStore);
            return;
        }

        Node<K, V> cur = new Node<K, V>(key, val);
        keyAndNodeMap.put(key, cur);

        if (null == head) {
            tail = cur;
        }
        addToHead(cur);

        if (keyAndNodeMap.size() > size) {
            removeTail();
        }
    }

    public V get(K key) {
        if (!keyAndNodeMap.containsKey(key)) {
            return null;
        }

        Node<K, V> hasStore = keyAndNodeMap.get(key);
        addToHead(hasStore);
        return hasStore.val;
    }

    private void addToHead(Node<K, V> node) {
        if (head == node) {
            return;
        }
        if (null == head) {
            head = node;
            return;
        }
        Node<K, V> pre = node.pre;
        Node<K, V> next = node.next;
        if (null != pre) {
            pre.next = next;
        }
        if (null != next) {
            next.pre = pre;
        }
        if (tail == node) {
            tail = pre;
        }

        node.next = head;
        head.pre = node;
        node.pre = null;
        head = node;
    }

    private void removeTail() {
        if (null == tail) {
            return;
        }

        Node<K, V> pre = tail.pre;
        pre.next = null;
        tail.pre = null;
        tail = pre;
    }

    private void print() {
        Node<K, V> cur = head;
        while (cur != null) {
            System.out.print(cur.key + " = " + cur.val + ", ");
            cur = cur.next;
        }
    }

    public static void main(String... args) {
        MyLru<String, Integer> myLru = new MyLru<>(5);
        myLru.set("1", 1);
        System.out.println(myLru.get("1"));
        myLru.set("NULL", null);
        System.out.println(myLru.get("NULL"));
        myLru.set("3", 3);
        System.out.println(myLru.get("haha"));
        myLru.set("4", 4);
        myLru.set("5", 5);
        myLru.set("3", 6);
        myLru.set("0", 100);
        System.out.println(myLru.get("3"));
        myLru.print();
    }
}