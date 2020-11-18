/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.list;

/**
 * 实现两个有序的链表合并为一个有序链表
 *
 * @author xingye
 * @created 2020/11/19
 */
public class MergeList {
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

    private Node mergeList(Node node1, Node node2) {
        if (null == node1) {
            return node2;
        }
        if (null == node2) {
            return node1;
        }

        Node head = null;
        Node pre = null, cur = null;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                cur = node1;
                node1 = node1.next;
            } else {
                cur = node2;
                node2 = node2.next;
            }

            if (null == head) {
                head = cur;
                pre = cur;
            } else {
                pre.next = cur;
                pre = cur;
            }
        }

        if (node1 != null) {
            cur.next = node1;
        }
        if (node2 != null) {
            cur.next = node2;
        }
        return head;
    }

    public static void main(String... args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node5;

        node2.next = node3;
        node3.next = node4;
        node4.next = node6;

        MergeList mergeList = new MergeList();
        System.out.println(mergeList.mergeList(node1, node2));
    }
}