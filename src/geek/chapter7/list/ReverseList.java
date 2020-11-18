/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.list;

/**
 * 实现单链表反转
 *
 * @author xingye
 * @created 2020/11/19
 */
public class ReverseList {
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

    private Node reverseList(Node head) {
        if (null == head) {
            return null;
        }

        Node pre = null;
        Node cur = head;
        Node next = cur.next;

        while (next != null) {
            cur.next = pre;

            pre = cur;
            cur = next;
            next = next.next;
        }
        cur.next = pre;

        return cur;
    }

    public static void main(String... args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node5 = new Node(5);
        Node node8 = new Node(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node5;
        node5.next = node8;

        ReverseList reverseList = new ReverseList();
        System.out.println(reverseList.reverseList(node1));
    }
}