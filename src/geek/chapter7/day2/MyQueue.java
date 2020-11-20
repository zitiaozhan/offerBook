/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day2;

import java.util.Arrays;

/**
 * 用数组实现一个顺序队列
 * 用链表实现一个链式队列
 * 实现一个循环队列
 *
 * @author xingye
 * @created 2020/11/20
 */
public class MyQueue {

    private static class ArrayQueue {
        private int[] nums;
        private int size;
        private int start;
        private int end;

        public ArrayQueue(int size) {
            this.size = size;
            this.nums = new int[size];
            this.end = 0;
            this.start = 0;
        }

        public void add(int num) {
            if (end >= size) {
                throw new RuntimeException();
            }
            nums[end] = num;
            end = (end + 1) % size;
        }

        public int poll() {
            if (start == end) {
                throw new RuntimeException();
            }
            int num = nums[start];
            start = (start + 1) % size;
            return num;
        }
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }
    }

    private static class ListQueue {
        private Node head;
        private Node tail;

        public void add(int num) {
            Node cur = new Node(num);
            if (null == head) {
                head = cur;
                tail = cur;
                return;
            }
            tail.next = cur;
            tail = cur;
        }

        public int poll() {
            if (null == head) {
                throw new RuntimeException();
            }
            Node next = head.next;
            int res = head.val;
            head.next = null;
            head = next;
            return res;
        }
    }

    public static void main(String... args) {
        ArrayQueue arrayQueue = new ArrayQueue(5);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        arrayQueue.add(4);
        arrayQueue.add(5);
        arrayQueue.add(6);
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        arrayQueue.add(7);
        System.out.println(Arrays.toString(arrayQueue.nums));
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());
        System.out.println(arrayQueue.poll());

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>#");
        ListQueue listQueue = new ListQueue();
        listQueue.add(1);
        listQueue.add(2);
        listQueue.add(3);
        System.out.println(listQueue.poll());
        System.out.println(listQueue.poll());
        listQueue.add(4);
        listQueue.add(5);
        listQueue.add(6);
        System.out.println(listQueue.poll());
        System.out.println(listQueue.poll());
        listQueue.add(7);
        System.out.println(listQueue.head);
        System.out.println(listQueue.poll());
        System.out.println(listQueue.poll());
        System.out.println(listQueue.poll());
    }

}