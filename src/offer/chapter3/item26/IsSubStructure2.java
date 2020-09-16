/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item26;

/**
 * P148
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author xingye
 * @created 2020/9/15
 */
public class IsSubStructure2 {

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null == A || null == B) {
            return false;
        }
        if (A == B) {
            return true;
        }

        // 前序遍历查看节点是否为子结构
        return preOrder(A, B);
    }

    private boolean preOrder(TreeNode A, TreeNode B) {
        if (null == A) {
            return false;
        }

        return isSubStructureCore(A, B) || preOrder(A.left, B) || preOrder(A.right, B);
    }

    private boolean isSubStructureCore(TreeNode A, TreeNode B) {
        if ((null == A && null != B)) {
            return false;
        }
        if (null == A || null == B) {
            return true;
        }
        if (A.val == B.val) {
            boolean left = isSubStructureCore(A.left, B.left);
            boolean right = isSubStructureCore(A.right, B.right);
            return left && right;
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

    public static void main(String... args) {
        IsSubStructure2 isSubStructure2 = new IsSubStructure2();

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(0);
        node2.left = node4;
        node2.right = node5;

        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(1);
        node6.left = node7;

        System.out.println(isSubStructure2.isSubStructure(node1, node1));
    }
}