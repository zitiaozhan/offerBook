/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item55;

/**
 * P273
 * 平衡二叉树判断
 *
 * @author xingye
 * @created 2020/9/1
 */
public class BalanceBiTree {
    public static void main(String... args) {
        BalanceBiTree balanceBiTree = new BalanceBiTree();
        /*Node node1 = new Node(5);
        System.out.println(balanceBiTree.judgeTree(node1));
        Node node2 = new Node(3);
        Node node3 = new Node(7);
        node1.left = node2;
        System.out.println(balanceBiTree.judgeTree(node1));
        node1.right = node3;
        System.out.println(balanceBiTree.judgeTree(node1));
        Node node4 = new Node(2);
        Node node5 = new Node(4);
        node2.left = node4;
        System.out.println(balanceBiTree.judgeTree(node1));
        node2.right = node5;
        System.out.println(balanceBiTree.judgeTree(node1));
        Node node6 = new Node(6);
        Node node7 = new Node(8);
        node3.left = node6;
        System.out.println(balanceBiTree.judgeTree(node1));
        node3.right = node7;
        System.out.println(balanceBiTree.judgeTree(node1));*/

        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node8.left = node9;
        Node node10 = new Node(10);
        node9.left = node10;
        Node node11 = new Node(11);
        node10.right = node11;
        System.out.println(balanceBiTree.judgeTree(node8));
    }

    private boolean judgeTree(Node node) {
        if (null == node) {
            return true;
        }

        // 分别判断左右子树是否为平衡二叉树
        getDepth(node);
        return isBalance;
    }

    private boolean isBalance = true;

    private int getDepth(Node node) {
        if (null == node) {
            isBalance = true;
            return 0;
        }

        int left = getDepth(node.left);
        if (!isBalance) {
            return 0;
        }
        int right = getDepth(node.right);
        if (!isBalance) {
            return 0;
        }
        if (Math.abs(left - right) > 1) {
            isBalance = false;
            return 0;
        }
        return Math.max(left, right) + 1;
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }

    }
}