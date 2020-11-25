/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day4;

/**
 * 实现一个基于链表法解决冲突问题的散列表
 *
 * @author xingye
 * @created 2020/11/25
 */
public class MyMap {
    private Node[] nodes;
    private int capacity;
    private int size;

    private static class Node {
        private String key;
        private int val;
        private Node next;

        public Node(String key, int val) {
            this.key = key;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "key='" + key + '\'' + ", val=" + val + ", next=" + next + '}';
        }
    }

    public MyMap(int capacity) {
        // capacity为2的次幂
        this.capacity = capacity;
        this.nodes = new Node[capacity];
        this.size = 0;
    }

    public void put(String key, int val) {
        if (size == capacity) {
            throw new RuntimeException();
        }
        size++;
        Node cur = new Node(key, val);
        boolean keyNull = null == key;

        int index = getIndex(key);
        Node head = nodes[index];
        if (null == head) {
            nodes[index] = cur;
        } else {
            Node tail = head;
            while (tail.next != null) {
                if ((!keyNull && tail.key.equals(key)) || (keyNull && tail.key == null)) {
                    // key相等，覆盖
                    tail.val = val;
                    return;
                }
                tail = tail.next;
            }

            // 无相等的值
            if ((!keyNull && tail.key.equals(key)) || (keyNull && tail.key == null)) {
                // key相等，覆盖
                tail.val = val;
            } else {
                tail.next = cur;
            }
        }
    }

    private int getIndex(String key) {
        if (null == key) {
            return 0;
        }
        return key.hashCode() & (capacity - 1);
    }

}