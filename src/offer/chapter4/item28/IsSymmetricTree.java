/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item28;

/**
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author xingye
 * @created 2020/7/29
 */
public class IsSymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSame(root.left, root.right);
    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }

        return isSame(root1.left, root2.right) && isSame(root1.right, root2.left);
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