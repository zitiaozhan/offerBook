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
public class MyLru {
    private static class Node {
        private String key;
        private Integer val;
        private Node pre;
        private Node next;

        public Node(String key, Integer val) {
            this.key = key;
            this.val = val;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private Map<String, Node> keyAndNodeMap = new HashMap<>();

    public MyLru(int size) {
        this.size = size;
    }

    public void set(String key, Integer val) {
        // 检查是否重复
        Node hasStore = keyAndNodeMap.get(key);
        if (null != hasStore) {
            // 直接覆盖
            hasStore.val = val;
            addToHead(hasStore);
            return;
        }

        Node cur = new Node(key, val);
        keyAndNodeMap.put(key, cur);

        if (null == head) {
            tail = cur;
        }
        addToHead(cur);

        if (keyAndNodeMap.size() > size) {
            removeTail();
        }
    }

    public Integer get(String key) {
        if (!keyAndNodeMap.containsKey(key)) {
            return null;
        }

        Node hasStore = keyAndNodeMap.get(key);
        addToHead(hasStore);
        return hasStore.val;
    }

    private void addToHead(Node node) {
        if (head == node) {
            return;
        }
        if (null == head) {
            head = node;
            return;
        }
        Node pre = node.pre;
        Node next = node.next;
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

        Node pre = tail.pre;
        pre.next = null;
        tail.pre = null;
        tail = pre;
    }

    private void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.key + " = " + cur.val + ", ");
            cur = cur.next;
        }
    }

    public static void main(String... args) {
        MyLru myLru = new MyLru(5);
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