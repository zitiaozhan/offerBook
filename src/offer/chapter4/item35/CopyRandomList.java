/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item35;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * @author xingye
 * @created 2020/9/17
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }

        // 1.复制节点
        Node cur = head;
        while (cur != null) {
            Node copyNode = new Node(cur.val);
            // next指针指向copy
            Node next = cur.next;
            cur.next = copyNode;
            copyNode.next = next;

            cur = next;
        }

        // 2.复制random指针
        cur = head;
        while (cur != null) {
            // 当前节点的拷贝节点
            Node copyCur = cur.next;
            // 复制random
            copyCur.random = cur.random == null ? null : cur.random.next;

            cur = cur.next.next;
        }

        // 3.链表分离
        Node copyHead = head.next;
        cur = head;
        while (cur != null) {
            Node copyCur = cur.next;
            // 原链表next指针复原
            cur.next = copyCur.next;
            // 拷贝链表next指针连接
            if (null != copyCur.next) {
                copyCur.next = copyCur.next.next;
            }

            cur = cur.next;
        }

        return copyHead;
    }

    private static class Node {
        private int val;
        private Node next;
        private Node random;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + ", next=" + next + '}';
        }
    }

    public static void main(String... args) {
        CopyRandomList copyComplexList = new CopyRandomList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.random = node1;

        Node node = copyComplexList.copyRandomList(node1);

        Node cur = node;
        while (cur != null) {
            Node next = cur.next;
            System.out.println(cur);
            System.out.println("sibling: " + cur.random);

            cur = next;
        }
    }

}