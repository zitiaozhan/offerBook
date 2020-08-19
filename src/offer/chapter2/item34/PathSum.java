/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item34;

import java.util.ArrayList;
import java.util.List;

/**
 * P182
 * 二叉树中为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * @author xingye
 * @created 2020/8/19
 */
public class PathSum {

    public static void main(String... args) {
        PathSum pathSum = new PathSum();

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        TreeNode treeNode6 = new TreeNode(6);
        treeNode3.right = treeNode6;


        System.out.println(pathSum.pathSum(treeNode1, 10));
    }

    public List<List<Integer>> pathSum(TreeNode node, int sum) {
        if (null == node) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        pathSum(node, sum, res, new ArrayList<>());
        return res;
    }

    private void pathSum(TreeNode node, int sum, List<List<Integer>> paths, List<Integer> path) {
        List<Integer> tempPath = new ArrayList<>(path);

        // 前序遍历
        tempPath.add(node.value);
        if (node.left == null && node.right == null) {
            // 叶节点
            int sum1 = tempPath.stream().mapToInt(Integer::intValue).sum();
            if (sum1 == sum) {
                paths.add(tempPath);
            }
            return;
        }
        if (node.left != null) {
            pathSum(node.left, sum, paths, tempPath);
        }
        if (node.right != null) {
            pathSum(node.right, sum, paths, tempPath);
        }
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