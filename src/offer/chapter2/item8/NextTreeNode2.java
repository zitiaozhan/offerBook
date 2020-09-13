/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item8;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/9/12
 */
public class NextTreeNode2 {

    private Node nextTreeNode(Node target) {
        if (null == target) {
            return null;
        }

        // 1.有右节点，下个节点为右最左
        if (target.right != null) {
            return rightNode(target.right);
        }
        // 2.节点为父节点左节点，下个节点为父节点
        Node parent = target.parent;
        if (null == parent) {
            return null;
        }
        if (parent.left == target) {
            return parent;
        }
        // 3.节点为父节点右节点，向上找，直到父节点为它的父节点的左节点，返回该父节点
        if (parent.right == target) {
            return rightParentNode(target.parent);
        }
        return null;
    }

    private Node rightNode(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return rightNode(node.left);
        }
    }

    private Node rightParentNode(Node node) {
        Node parent = node.parent;
        if (null == parent) {
            return null;
        }
        if (parent.left == node) {
            return parent;
        } else {
            return rightParentNode(parent);
        }
    }

    private static class Node {
        private int val;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "Node{" + "val=" + val + '}';
        }
    }

    public static void main(String... args) {
        NextTreeNode2 nextTreeNode2 = new NextTreeNode2();
        Node node1 = new Node(0);
        Node node2 = new Node(4);
        Node node3 = new Node(2);
        node1.left = node2;
        node2.parent = node1;
        node1.right = node3;
        node3.parent = node1;
        Node node4 = new Node(3);
        Node node5 = new Node(8);
        Node node6 = new Node(1);
        node2.left = node4;
        node4.parent = node2;
        node2.right = node5;
        node5.parent = node2;
        node3.left = node6;
        node6.parent = node3;
        Node node7 = new Node(7);
        Node node8 = new Node(3);
        Node node9 = new Node(5);
        node4.left = node7;
        node7.parent = node4;
        node5.left = node8;
        node8.parent = node5;
        node5.right = node9;
        node9.parent = node5;

        System.out.println(nextTreeNode2.nextTreeNode(node4));
        System.out.println(nextTreeNode2.nextTreeNode(node5));
        System.out.println(nextTreeNode2.nextTreeNode(node6));
        System.out.println(nextTreeNode2.nextTreeNode(node7));
        System.out.println(nextTreeNode2.nextTreeNode(node8));
        System.out.println(nextTreeNode2.nextTreeNode(node9));
    }

}