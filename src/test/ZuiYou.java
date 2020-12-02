/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/11/30
 */
public class ZuiYou {

    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    public void printTree(Node root) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        List<Integer> list = new ArrayList<>();

        Node curLine = root, nextLine = root;
        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();
            list.add(poll.val);
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
                System.out.println(list);
                list = new ArrayList<>();
            }
        }
    }

    public boolean mirrorTree(Node root) {
        if (null == root) {
            return true;
        }
        return mirrorTreeCore(root.left, root.right);
    }

    private boolean mirrorTreeCore(Node left, Node right) {
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }
        if (left == null) {
            return true;
        }

        if (left.val != right.val) {
            return false;
        }
        return mirrorTreeCore(left.left, right.right) && mirrorTreeCore(left.right, right.left);
    }

    public static void main(String... args) {

    }

}