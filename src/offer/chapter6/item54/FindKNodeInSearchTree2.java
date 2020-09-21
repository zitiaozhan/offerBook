/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item54;

import java.util.Stack;

/**
 * 二叉搜索树的第K大节点
 *
 * @author xingye
 * @created 2020/9/21
 */
public class FindKNodeInSearchTree2 {

    private Node findNode(Node root, int k) {
        if (null == root || k < 1) {
            return null;
        }

        // 中序遍历，得到第K大的数字
        Stack<Node> nodes = new Stack<>();
        while (root != null || !nodes.isEmpty()) {
            if (null != root) {
                nodes.push(root);
                root = root.left;
            } else {
                root = nodes.pop();
                if (k == 1) {
                    return root;
                }
                k--;

                root = root.right;
            }
        }

        return null;
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
        FindKNodeInSearchTree2 nodeInSearchTree2 = new FindKNodeInSearchTree2();
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

        System.out.println(nodeInSearchTree2.findNode(node1, 1));
        System.out.println(nodeInSearchTree2.findNode(node1, 2));
        System.out.println(nodeInSearchTree2.findNode(node1, 3));
        System.out.println(nodeInSearchTree2.findNode(node1, 4));
        System.out.println(nodeInSearchTree2.findNode(node1, 5));
        System.out.println(nodeInSearchTree2.findNode(node1, 6));
        System.out.println(nodeInSearchTree2.findNode(node1, 7));
        System.out.println(nodeInSearchTree2.findNode(node1, 8));
        System.out.println(nodeInSearchTree2.findNode(node1, 9));
    }

}