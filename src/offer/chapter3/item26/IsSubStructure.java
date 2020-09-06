/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item26;

import java.util.Stack;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author xingye
 * @created 2020/7/29
 */
public class IsSubStructure {
    public static void main(String... args) {

    }

    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        boolean res = false;

        if (null != A && null != B) {
            if (A.val == B.val) {
                res = isSame(A, B);
            }
            if (!res) {
                res = isSubStructure2(A.left, B);
            }
            if (!res) {
                res = isSubStructure2(A.right, B);
            }
        }

        return res;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }

        TreeNode parent = A;
        TreeNode sub = B;
        Stack<TreeNode> nodeStack = new Stack<>();
        nodeStack.add(parent);
        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            if (isSame(node, sub)) {
                return true;
            }
            if (null != node.right) {
                nodeStack.add(node.right);
            }
            if (null != node.left) {
                nodeStack.add(node.left);
            }
        }
        return false;
    }

    private boolean isSame(TreeNode parent, TreeNode sub) {
        if (sub == null) {
            return true;
        }
        if (parent == null) {
            return false;
        }
        if (parent.val != sub.val) {
            return false;
        }

        // 左子树
        boolean res = isSame(parent.left, sub.left);
        if (!res) {
            return false;
        }
        // 右子树
        res = res && isSame(parent.right, sub.right);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}