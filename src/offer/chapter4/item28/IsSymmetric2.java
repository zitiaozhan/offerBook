/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item28;

/**
 * P159
 * 剑指 Offer 28. 对称的二叉树
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author xingye
 * @created 2020/9/15
 */
public class IsSymmetric2 {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetricCore(root.left, root.right);
    }

    private boolean isSymmetricCore(TreeNode head1, TreeNode head2) {
        if ((null == head1 && null != head2) || (null == head2 && null != head1)) {
            return false;
        }
        if (null == head1) {
            return true;
        }
        if (head1.val == head2.val) {
            // 比较左右子树是否相等
            return isSymmetricCore(head1.left, head2.right) && isSymmetricCore(head1.right, head2.left);
        }
        return false;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}