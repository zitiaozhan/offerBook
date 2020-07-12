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
 * @created 2020/7/12
 */
public class NextTreeNode {

    public static void main(String... args) {
        NextTreeNode nextTreeNode = new NextTreeNode();
        TreeNode head = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        head.left = left;
        head.right = right;
        left.parent = head;
        right.parent = head;

        right.left = rightLeft;
        right.right = rightRight;
        rightLeft.parent = right;
        rightRight.parent = right;
        System.out.println(nextTreeNode.nextTreeNode(head));
    }

    /**
     * 最坏时间复杂度：O(lgN)
     *
     * @param node
     * @return
     */
    private TreeNode nextTreeNode(TreeNode node) {
        if (null == node) {
            return null;
        }

        TreeNode result = null;
        if (null != node.right) {
            // 1.如果所给节点有右节点，则下一个节点为右子树的最左节点
            TreeNode mostLeft = node.right;
            while (null != mostLeft.left) {
                mostLeft = mostLeft.left;
            }
            result = mostLeft;
        } else {
            // 2.如果所给节点没有右节点，需要分两种情况
            // 1)该节点为某节点的左子节点，下一个节点为该节点的父节点
            // 2)该节点不是左子节点，则一直向上找直到是它父节点的左子节点的节点，若存在，则该节点父节点为下个节点
            TreeNode leftSub = node;
            while (null != leftSub.parent && leftSub != leftSub.parent.left) {
                leftSub = leftSub.parent;
            }
            result = leftSub.parent;
        }

        return result;
    }

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
}