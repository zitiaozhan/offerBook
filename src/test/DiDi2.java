/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/12
 */
public class DiDi2 {

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node res;

    public Node getCommonParentNode(Node root, Node node1, Node node2) {
        res = null;
        if (null == root) {
            return null;
        }
        if (null == node1 || null == node2) {
            return null;
        }

        getNodeCore(root, node1, node2);
        return res;
    }

    private int getNodeCore(Node cur, Node node1, Node node2) {
        if (null == cur) {
            return 0;
        }

        int num = getNodeCore(cur.left, node1, node2) + getNodeCore(cur.right, node1, node2);
        if (num == -2) {
            res = cur;
            return 0;
        }
        if (cur == node1 || cur == node2) {
            return -1;
        }
        return num;
    }

    public Node lowestCommonAncestor(Node root, Node p, Node q) {
        if (root == p || root == q || root == null) {
            return root;
        }

        Node left = lowestCommonAncestor(root.left, p, q);
        Node right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    public static void main(String... args) {
        DiDi2 parents = new DiDi2();
        Node node1 = new Node(3);
        Node node2 = new Node(7);
        node1.right = node2;
        Node node3 = new Node(4);
        node2.left = node3;
        Node node4 = new Node(10);
        node2.right = node4;
        Node node5 = new Node(16);
        node3.left = node5;

        System.out.println(parents.getCommonParentNode(node1, node5, node4).val);
    }

    private Node lowestCommonAncestor2(Node cur, Node a, Node b) {
        if (null == cur || cur == a || cur == b) {
            return cur;
        }
        Node left = lowestCommonAncestor2(cur.left, a, b);
        Node right = lowestCommonAncestor2(cur.left, a, b);
        if (null != left && null != right) {
            return cur;
        }
        return left != null ? left : right;
    }

}