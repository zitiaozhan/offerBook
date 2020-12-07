/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item7;

/**
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 *
 * @author xingye
 * @created 2020/12/7
 */
public class BuildTree3 {
    private class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode buildTree(int[] preOrder, int[] inOrder) {
        if (null == preOrder || null == inOrder || preOrder.length != inOrder.length) {
            return null;
        }

        return buildCore(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    private TreeNode buildCore(int[] preOrder, int preLeft, int preRight, int[] inOrder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 1.通过前序序列找到根节点
        int rootVal = preOrder[preLeft];

        TreeNode root = new TreeNode(rootVal);

        // 2.在中序序列中得到左右子树长度
        int rootIndex = -1;
        for (int i = inLeft; i <= inRight; i++) {
            if (inOrder[i] == rootVal) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex == -1) {
            throw new RuntimeException();
        }
        int leftLen = rootIndex - inLeft;

        root.left = buildCore(preOrder, preLeft + 1, preLeft + leftLen, inOrder, inLeft, rootIndex - 1);
        root.right = buildCore(preOrder, preLeft + leftLen + 1, preRight, inOrder, rootIndex + 1, inRight);
        return root;
    }

}