/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item32;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * P171
 * 从上到下的打印二叉树
 *
 * @author xingye
 * @created 2020/8/16
 */
public class PrintTreeFromTopToBottom {
    public static void main(String... args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node3.left = node6;
        node4.right = node7;

        PrintTreeFromTopToBottom fromTopToBottom = new PrintTreeFromTopToBottom();
        fromTopToBottom.print(node1);
    }

    public void print(TreeNode root) {
        if (null == root) {
            return;
        }
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        List<TreeNode> nodeList = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            TreeNode treeNode = nodeQueue.remove();
            nodeList.add(treeNode);

            if (treeNode.left != null) {
                nodeQueue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                nodeQueue.add(treeNode.right);
            }
        }

        System.out.println(nodeList.stream().map(node -> String.valueOf(node.value)).collect(Collectors.joining(",")));
    }

    private static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }
}