/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item55;

/**
 * P271
 * 二叉树的深度
 *
 * @author xingye
 * @created 2020/9/1
 */
public class TreeDepth {

    public static void main(String... args) {
        TreeDepth treeDepth = new TreeDepth();
        Node node1 = new Node(5);
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        node1.left = node2;
        node1.right = node3;
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        node2.left = node4;
        node2.right = node5;
        Node node6 = new Node(6);
        Node node7 = new Node(8);
        node3.left = node6;
        node3.right = node7;

        System.out.println(treeDepth.treeDepth(node1));
        System.out.println(treeDepth.treeDepth(node2));
        System.out.println(treeDepth.treeDepth(node3));
        System.out.println(treeDepth.treeDepth(node4));
        System.out.println(treeDepth.treeDepth(node5));
        System.out.println(treeDepth.treeDepth(node6));
        System.out.println(treeDepth.treeDepth(node7));
    }

    private int treeDepth(Node node) {
        int depth = 0;
        if (null == node) {
            return depth;
        }

        // 递归，取左右子树深度的较大值
        return getDepth(node);
    }

    private int getDepth(Node node) {
        if (null == node) {
            return 0;
        }

        int left = getDepth(node.left) + 1;
        int right = getDepth(node.right) + 1;
        return Math.max(left, right);
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
}