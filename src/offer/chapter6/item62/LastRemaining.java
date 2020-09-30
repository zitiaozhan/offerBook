/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item62;

/**
 * P300
 * 圆圈中最后剩下的数字
 *
 * @author xingye
 * @created 2020/9/8
 */
public class LastRemaining {

    /**
     * 解法1：使用循环链表模拟圆圈
     *
     * @param n 0~n-1
     * @param m 第m个数
     * @return 最后剩下的数
     * DONE:解法2：P302
     */
    private int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }
        // 初始化：循环链表
        int size = n, index = 1;
        Node head = new Node(0);
        Node tail = head;
        while (index < n) {
            Node temp = new Node(index++);
            tail.next = temp;
            tail = temp;
        }
        tail.next = head;
        // 模拟删除
        index = 1;
        Node cur = head;
        Node pre = tail;
        while (size > 1) {
            if (index == m) {
                removeNode(pre, cur);
                size--;
                cur = pre.next;
                index = 1;
            } else {
                pre = cur;
                cur = cur.next;
                index++;
            }
        }
        return cur.val;
    }

    private void removeNode(Node pre, Node cur) {
        pre.next = cur.next;
        cur.next = null;
    }

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String... args) {
        LastRemaining lastRemaining = new LastRemaining();
        System.out.println(lastRemaining.lastRemaining(3, 1));
        System.out.println(lastRemaining.lastRemaining(5, 3));
    }

}