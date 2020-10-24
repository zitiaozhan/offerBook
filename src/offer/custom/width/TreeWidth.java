/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.width;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 计算树的宽度
 *
 * @author xinyeguo
 * @created 2020/10/10
 */
public class TreeWidth {
    public int getTreeWidth(TreeNode root) {
        if (null == root) {
            return 0;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        TreeNode nextLevel = root, curPrint = root;
        int width = 0, maxWidth = 0;
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            width++;
            if (null != node.left) {
                nodeQueue.offer(node.left);
                nextLevel = node.left;
            }
            if (null != node.right) {
                nodeQueue.offer(node.right);
                nextLevel = node.right;
            }

            if (node == curPrint) {
                // 这一层完毕
                maxWidth = Math.max(width, maxWidth);

                curPrint = nextLevel;
                width = 0;
            }
        }
        return maxWidth;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "val=" + val + '}';
        }
    }

    public static void main(String... args) {
        TreeWidth treeWidth = new TreeWidth();

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;

        System.out.println(treeWidth.getTreeWidth(node1));
    }
}