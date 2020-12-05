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
 * @created 2020/12/4
 */
public class MinCommonParents2 {
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node node = null;

    private Node minCommonParent(Node root, Node node1, Node node2) {
        node = null;
        if (null == node1 || null == node2 || null == root) {
            return null;
        }

        minCommonParentCore(root, node1, node2);
        return node;
    }

    private int minCommonParentCore(Node curNode, Node node1, Node node2) {
        if (null == node1 || null == node2 || null == curNode) {
            return 0;
        }

        if (curNode == node1 || curNode == node2) {
            return -1;
        }
        int value = 0;
        value += minCommonParentCore(curNode.left, node1, node2);
        value += minCommonParentCore(curNode.right, node1, node2);

        if (-2 == value) {
            node = curNode;
            return 0;
        }
        return value;
    }

    public static void main(String... args) {
        MinCommonParents2 parents = new MinCommonParents2();
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
        System.out.println(parents.minCommonParent(node1, node5, node3).val);
    }
}