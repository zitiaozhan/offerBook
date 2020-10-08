/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * 搜索二叉树转双向链表
 * 中序遍历
 *
 * @author xingye
 * @created 2020/9/26
 */
public class TreeToDoublyList3 {

    private Node treeToDoublyList(Node node) {
        node = treeToDoublyListCore(node);
        // 头结点
        Node head = node;
        while (head.left != null) {
            head = head.left;
        }
        // 为节点
        Node tail = node;
        while (tail.right != null) {
            tail = tail.right;
        }

        // 收尾相连
        head.left = tail;
        tail.right = head;
        return head;
    }

    private Node treeToDoublyListCore(Node node) {
        if (null == node) {
            return null;
        }

        // 中序遍历
        Node leftNode = treeToDoublyListCore(node.left);
        node.left = leftNode;
        if (null != leftNode) {
            leftNode.right = node;
        }
        Node rightNode = treeToDoublyListCore(node.right);
        node.right = rightNode;
        if (null != rightNode) {
            rightNode.left = node;
        }
        return node;
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + '}';
        }
    }

    public static void main(String... args) {
        TreeToDoublyList3 toDoublyList3 = new TreeToDoublyList3();

        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(8);
        Node node7 = new Node(12);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        Node head = toDoublyList3.treeToDoublyList(node1);
        for (int i = 0; i < 7; i++) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}