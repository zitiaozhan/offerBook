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

/**
 * 实现一个二叉查找树，并且支持插入、删除、查找操作
 *
 * @author xingye
 * @created 2020/11/27
 */
public class BiFindTree {
    private static class Node {
        private int val;
        private Node left;
        private Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    private Node root;

    public void add(int val) {
        Node node = new Node(val);
        if (null == root) {
            root = node;
            return;
        }

        Node parent = root;
        while (true) {
            if (val <= parent.val) {
                if (null == parent.left) {
                    parent.left = node;
                    break;
                } else {
                    parent = parent.left;
                }
            } else {
                if (null == parent.right) {
                    parent.right = node;
                    break;
                } else {
                    parent = parent.right;
                }
            }
        }
    }

    public boolean removeNode(int val) {
        if (null == root) {
            return false;
        }

        if (root.val == val) {
            // 根节点
            root = replace(root);
        } else {
            Node parent = findParent(val);
            if (null == parent) {
                return false;
            }
            if (parent.left.val == val) {
                parent.left = replace(parent.left);
            } else if (parent.right.val == val) {
                parent.right = replace(parent.right);
            }
        }
        return true;
    }

    private Node replace(Node cur) {
        Node res = null;
        if (cur.left != null && cur.right != null) {
            res = cur.left;
            res.left = replace(cur.left);
            res.right = cur.right;
        } else if (cur.left != null) {
            res = cur.left;
        } else if (cur.right != null) {
            return cur.right;
        }
        // 置空
        cur.left = null;
        cur.right = null;
        return res;
    }

    private Node findParent(int val) {
        if (null == root) {
            return null;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            Node node = nodes.poll();
            if (null != node.left) {
                if (node.left.val == val) {
                    return node;
                }
                nodes.add(node.left);
            }
            if (null != node.right) {
                if (node.right.val == val) {
                    return node;
                }
                nodes.add(node.right);
            }
        }
        return null;
    }

    private void print() {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> line = new ArrayList<>();

        Node curLine = root, nextLine = root;
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            Node poll = nodeQueue.poll();
            line.add(poll.val);

            if (null != poll.left) {
                nextLine = poll.left;
                nodeQueue.add(poll.left);
            }
            if (null != poll.right) {
                nextLine = poll.right;
                nodeQueue.add(poll.right);
            }

            if (poll == curLine) {
                curLine = nextLine;
                res.add(line);
                line = new ArrayList<>();
            }
        }

        System.out.println(res);
    }

    public static void main(String... args) {
        BiFindTree biFindTree = new BiFindTree();
        biFindTree.add(19);
        biFindTree.add(11);
        biFindTree.add(55);
        biFindTree.add(2);
        biFindTree.add(17);
        biFindTree.add(99);
        biFindTree.print();
        biFindTree.removeNode(55);
        biFindTree.print();
    }
}