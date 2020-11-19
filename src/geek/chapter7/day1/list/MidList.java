/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day1.list;

/**
 * 实现求链表的中间结点
 *
 * @author xingye
 * @created 2020/11/19
 */
public class MidList {
    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + '}';
        }
    }

    private Node midList1(Node head) {
        if (null == head) {
            return null;
        }

        // 双指针获取中间节点
        Node slow = head;
        Node quick = head;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private Node midList2(Node head) {
        if (null == head) {
            return null;
        }

        // 双指针获取中间节点
        Node slow = head;
        Node quick = head;
        quick = quick.next;
        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String... args) {
        MidList midList = new MidList();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.println(midList.midList1(node1));
        System.out.println(midList.midList2(node1));
        node5.next = node6;
        System.out.println(midList.midList1(node1));
        System.out.println(midList.midList2(node1));
    }
}