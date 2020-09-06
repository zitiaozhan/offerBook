/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item36;

/**
 * P191
 * 二叉搜索树与双向链表
 * 剑指 Offer 36. 二叉搜索树与双向链表
 *
 * @author xingye
 * @created 2020/8/19
 */
public class TreeConvertList {

    public static void main(String... args) {
        TreeConvertList treeConvertList = new TreeConvertList();

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        Node node = treeConvertList.treeToDoublyList(node1);

        for (int i = 0; i < 5; i++) {
            System.out.println(node.val);
            node = node.right;
        }
    }

    public Node treeToDoublyList(Node root) {
        if (null == root) {
            return root;
        }

        Node[] nodes = new Node[2];
        treeToDoublyList(root, nodes);
        if (null != nodes[0]) {
            nodes[0].left = nodes[1];
        }
        if (null != nodes[1]) {
            nodes[1].right = nodes[0];
        }
        return nodes[0];
    }

    private void treeToDoublyList(Node root, Node[] nodes) {
        // 中序遍历
        if (null == root) {
            return;
        }

        if (null != root.left) {
            treeToDoublyList(root.left, nodes);
        }

        if (null == nodes[0]) {
            nodes[0] = root;
        }
        root.left = nodes[1];
        if (null != nodes[1]) {
            nodes[1].right = root;
        }
        nodes[1] = root;

        if (null != root.right) {
            treeToDoublyList(root.right, nodes);
        }
    }

    private static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
        }
    }
}