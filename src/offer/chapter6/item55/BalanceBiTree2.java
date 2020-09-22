/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item55;

/**
 * 判断一棵树是不是平衡二叉树
 *
 * @author xingye
 * @created 2020/9/22
 */
public class BalanceBiTree2 {

    private boolean balanceTree(Node root) {
        if (null == root) {
            return true;
        }

        int leftDepth = treeDepth(root.left);
        int rightDepth = treeDepth(root.right);
        return Math.abs(leftDepth - rightDepth) <= 1;
    }

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
        BalanceBiTree2 balanceBiTree2=new BalanceBiTree2();
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node8.left = node9;
        Node node10 = new Node(10);
        node8.right = node10;
        Node node11 = new Node(11);
        node10.right = node11;
        System.out.println(balanceBiTree2.balanceTree(node8));
    }

}