/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item68;

/**
 * P326
 * 树中两个节点的最低公共祖先
 *
 * @author xingye
 * @created 2020/9/9
 */
public class MinCommonParents {

    private Node minCommonParent(Node root, Node node1, Node node2) {
        commonParent = null;
        if (null == root || null == node1 || null == node2) {
            return null;
        }

        commonParentCore(root, node1, node2);
        return commonParent;
    }

    private Node commonParent = null;

    private int commonParentCore(Node root, Node node1, Node node2) {
        if (root == node1 || root == node2) {
            return -1;
        }

        int curNodeSum = 0;
        if (null != root.left) {
            curNodeSum += commonParentCore(root.left, node1, node2);
        }
        if (null != root.right) {
            curNodeSum += commonParentCore(root.right, node1, node2);
        }
        if (-2 == curNodeSum) {
            commonParent = root;
            return 0;
        }
        return curNodeSum;
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
        MinCommonParents parents = new MinCommonParents();
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        node1.right = node2;
        Node node3 = new Node(4);
        node2.left = node3;
        Node node4 = new Node(10);
        node2.right = node4;
        Node node5 = new Node(16);
        node3.left = node5;

        System.out.println(parents.minCommonParent(node1, node5, node4).val);
        System.out.println(parents.minCommonParent(node1, node5, node2).val);
    }
}