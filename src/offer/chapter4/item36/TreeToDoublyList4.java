/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * 二叉搜索树与双向链表
 *
 * @author xingye
 * @created 2020/10/8
 */
public class TreeToDoublyList4 {
    private Node head;
    private Node pre;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        midOrder(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    private void midOrder(Node cur) {
        if (null == cur) {
            return;
        }

        midOrder(cur.left);

        if (null == pre) {
            head = cur;
        } else {
            pre.right = cur;
            cur.left = pre;
        }
        pre = cur;

        midOrder(cur.right);
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
        TreeToDoublyList4 toDoublyList4 = new TreeToDoublyList4();

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

        Node head = toDoublyList4.treeToDoublyList(node1);
        for (int i = 0; i < 7; i++) {
            System.out.println(head.val);
            head = head.right;
        }
    }
}