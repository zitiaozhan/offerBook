/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * 在这里编写类的功能描述
 *
 * @author xinyeguo
 * @created 2020/10/10
 */
public class TreeToDoublyList5 {
    private Node pre = null, head = null;

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return null;
        }

        treeToDoublyListCore(root);
        pre.right = head;
        head.left = pre;
        return head;
    }

    private void treeToDoublyListCore(Node root) {
        if (null == root) {
            return;
        }

        treeToDoublyListCore(root.left);
        if (pre == null) {
            head = root;
        }
        root.left = pre;
        if (null != pre) {
            pre.right = root;
        }
        pre = root;
        treeToDoublyListCore(root.right);
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
        TreeToDoublyList5 toDoublyList = new TreeToDoublyList5();

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

        Node head = toDoublyList.treeToDoublyList(node1);
        for (int i = 0; i < 7; i++) {
            System.out.println(head.val);
            head = head.right;
        }
    }

}