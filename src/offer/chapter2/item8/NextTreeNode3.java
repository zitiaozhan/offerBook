/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item8;

/**
 * 二叉树的下一个节点
 * 给定一棵二叉树和其中的一个节点，如何找出中序遍历序列的下一个节点？
 * 树中的节点除了有两个分别指向左右子节点的指针，还有一个只想父节点的指针。
 *
 * @author xingye
 * @created 2020/12/7
 */
public class NextTreeNode3 {
    private static class TreeNode {
        int value;
        TreeNode parent;
        TreeNode left;
        TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "TreeNode{" + "value=" + value + '}';
        }
    }

    private TreeNode nextNode(TreeNode root, TreeNode cur) {
        if (null != cur.right) {
            // 1.有右节点，返回右节点
            return cur.right;
        }

        // 2.该节点是否为父节点的左节点
        TreeNode parent = cur.parent;
        if (null != parent && cur == parent.left) {
            return parent;
        }
        // 3.没有右节点，向上找，直到该节点为父节点的左节点
        while (parent != null) {
            if (cur == parent.left) {
                return parent;
            }
            cur = parent;
            parent = parent.parent;
        }
        return null;
    }

}