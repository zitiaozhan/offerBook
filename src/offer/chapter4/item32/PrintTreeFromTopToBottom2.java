/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item32;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * P171
 * 从上到下打印二叉树
 *
 * @author xingye
 * @created 2020/9/16
 */
public class PrintTreeFromTopToBottom2 {

    private List<Integer> print(TreeNode root) {
        if (null == root) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res.add(node.val);

            if (null != node.left) {
                queue.offer(node.left);
            }
            if (null != node.right) {
                queue.offer(node.right);
            }
        }
        return res;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

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

        PrintTreeFromTopToBottom2 bottom2 = new PrintTreeFromTopToBottom2();
        System.out.println(bottom2.print(node1));
    }

}