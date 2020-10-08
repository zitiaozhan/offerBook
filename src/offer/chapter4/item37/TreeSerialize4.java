/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item37;

import java.util.Stack;

/**
 * 输的序列化与反序列化
 *
 * @author xingye
 * @created 2020/10/8
 */
public class TreeSerialize4 {

    public String preOrderSerialize(Node node) {
        StringBuilder builder = new StringBuilder();
        preOrder(node, builder);

        String target = builder.toString();
        return target.substring(0, target.length() - 1);
    }

    private void preOrder(Node node, StringBuilder builder) {
        if (null == node) {
            builder.append("*").append("#");
            return;
        }

        builder.append(node.val).append("#");
        preOrder(node.left, builder);
        preOrder(node.right, builder);
    }

    public Node preOrderDeserialize(String target) {
        if (null == target || target.length() == 0) {
            return null;
        }

        String[] nodes = target.split("#");
        return preOrderDeserializeCore(nodes);
    }

    private int index = 0;

    private Node preOrderDeserializeCore(String[] nodes) {
        String curNode = nodes[index++];
        if ("*".equals(curNode)) {
            return null;
        }

        Node node = new Node(Integer.parseInt(curNode));
        Node left = preOrderDeserializeCore(nodes);
        Node right = preOrderDeserializeCore(nodes);
        node.left = left;
        node.right = right;
        return node;
    }

    private void print(Node root) {
        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        Stack<Node> reverse = new Stack<>();
        while (!nodeStack.isEmpty()) {
            Node node = nodeStack.pop();
            reverse.push(node);
            if (null != node.left) {
                nodeStack.push(node.left);
            }
            if (null != node.right) {
                nodeStack.push(node.right);
            }
        }

        while (!reverse.isEmpty()) {
            System.out.println(reverse.pop());
        }
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
        Node node1 = new Node(7);
        Node node2 = new Node(5);
        Node node3 = new Node(3);
        Node node4 = new Node(6);
        Node node5 = new Node(9);
        Node node6 = new Node(8);
        Node node7 = new Node(12);

        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        node1.right = node5;
        node5.left = node6;
        node5.right = node7;

        TreeSerialize4 treeSerialize4 = new TreeSerialize4();
        String serialize = treeSerialize4.preOrderSerialize(node1);
        System.out.println(serialize);
        Node node = treeSerialize4.preOrderDeserialize(serialize);
        treeSerialize4.print(node);
        serialize = treeSerialize4.preOrderSerialize(node1);
        System.out.println(serialize);
    }
}