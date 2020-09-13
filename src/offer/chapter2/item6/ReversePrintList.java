/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item6;

/**
 * P58
 * 从尾到头打印链表
 *
 * @author xingye
 * @created 2020/9/12
 */
public class ReversePrintList {

    private void reversePrint(Node node) {
        if (null == node) {
            return;
        }

        reversePrint(node.next);
        System.out.println(node);
    }

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

    public static void main(String... args) {
        ReversePrintList printList = new ReversePrintList();
        Node node1 = new Node(6);
        Node node2 = new Node(3);
        node1.next = node2;
        Node node3 = new Node(4);
        node2.next = node3;
        Node node4 = new Node(0);
        node3.next = node4;
        Node node5 = new Node(0);
        node4.next = node5;
        Node node6 = new Node(2);
        node5.next = node6;

        printList.reversePrint(node1);
        printList.reversePrint(node6);
        printList.reversePrint(null);
    }

}