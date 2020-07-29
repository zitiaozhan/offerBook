/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item27;

/**
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author xingye
 * @created 2020/7/29
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return root;
        }
        return mirrorTreeCore(root);
    }

    private TreeNode mirrorTreeCore(TreeNode root) {
        if (null == root) {
            return root;
        }
        TreeNode left = mirrorTreeCore(root.left);
        TreeNode right = mirrorTreeCore(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}