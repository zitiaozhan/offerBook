/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item55;

/**
 * 二叉树的深度
 *
 * @author xingye
 * @created 2020/9/22
 */
public class TreeDepth2 {

    private int treeDepth(Node root) {
        if (null == root) {
            return 0;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String... args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.left = node2;
        node2.left = node3;
        node3.right = node4;
        node4.left = node5;
        node4.right = node6;

        TreeDepth2 treeDepth2 = new TreeDepth2();
        System.out.println(treeDepth2.treeDepth(node1));
        System.out.println(treeDepth2.treeDepth(node2));
        System.out.println(treeDepth2.treeDepth(node3));
        System.out.println(treeDepth2.treeDepth(node4));
        System.out.println(treeDepth2.treeDepth(node5));
    }

}