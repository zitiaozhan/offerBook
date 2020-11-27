/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day5;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/11/27
 */
public class BiTreeOutput {
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private void preOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> nodeStack = new Stack<>();
        nodeStack.push(root);
        while (!nodeStack.isEmpty()) {
            Node pop = nodeStack.pop();
            res.add(pop.val);

            if (null != pop.right) {
                nodeStack.push(pop.right);
            }
            if (null != pop.left) {
                nodeStack.push(pop.left);
            }
        }
        System.out.println(res);
    }

    private void midOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> nodeStack = new Stack<>();
        while (root != null || !nodeStack.isEmpty()) {
            if (null != root) {
                nodeStack.add(root);
                root = root.left;
            } else {
                root = nodeStack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        System.out.println(res);
    }

    private void postOrder(Node root) {
        List<Integer> res = new ArrayList<>();

        Stack<Node> nodeStack = new Stack<>();
        Stack<Node> printStack = new Stack<>();
        nodeStack.add(root);
        while (!nodeStack.isEmpty()) {
            Node pop = nodeStack.pop();
            printStack.add(pop);

            if (null != pop.left) {
                nodeStack.add(pop.left);
            }
            if (null != pop.right) {
                nodeStack.add(pop.right);
            }
        }
        while (!printStack.isEmpty()) {
            res.add(printStack.pop().val);
        }

        System.out.println(res);
    }

    private void bfs(Node root) {
        List<Integer> res = new ArrayList<>();

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();
            res.add(poll.val);
            if (null != poll.left) {
                nodeQueue.add(poll.left);
            }
            if (null != poll.right) {
                nodeQueue.add(poll.right);
            }
        }

        System.out.println(res);
    }

    private void byLine(Node root) {
        List<Integer> res = new ArrayList<>();
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        Node curLine = root, nextLine = root;
        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();
            res.add(poll.val);
            if (null != poll.left) {
                nextLine = poll.left;
                nodeQueue.add(poll.left);
            }
            if (null != poll.right) {
                nextLine = poll.right;
                nodeQueue.add(poll.right);
            }

            if (curLine == poll) {
                curLine = nextLine;
                System.out.println(res);
                res = new ArrayList<>();
            }
        }
    }

    public static void main(String... args) {
        BiTreeOutput biTreeOutput = new BiTreeOutput();
        Node root = biTreeOutput.init();
        // 12,6,3,0,6,7,2,8
        biTreeOutput.preOrder(root);
        // 3,6,0,12,2,8,7,6
        biTreeOutput.midOrder(root);
        // 3,0,6,8,2,7,6,12
        biTreeOutput.postOrder(root);
        // 12,6,6,3,0,7,2,8
        biTreeOutput.bfs(root);
        biTreeOutput.byLine(root);
    }

    private Node init() {
        Node node1 = new Node(12);
        Node node2 = new Node(6);
        Node node3 = new Node(6);
        Node node4 = new Node(3);
        Node node5 = new Node(0);
        Node node6 = new Node(7);
        Node node7 = new Node(2);
        Node node8 = new Node(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node3.left = node6;
        node6.left = node7;
        node7.right = node8;
        return node1;
    }

}