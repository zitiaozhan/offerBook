/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author xingye
 * @created 2020/7/12
 */
public class BuildTree {

    public static void main(String... args) {
        BuildTree buildTree = new BuildTree();
        buildTree.printByLevel(buildTree.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{3, 9, 20, 15, 7}));
    }

    /**
     * 根据前序树序列与中序树序列构建二叉树，
     * 将构建树的任务分解为构建左右节点的小任务
     *
     * @param preorder 前序序列
     * @param inorder  中序树序列
     * @return 二叉树根节点
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || 0 == preorder.length || 0 == inorder.length) {
            return null;
        }
        if (preorder.length != inorder.length) {
            throw new IllegalArgumentException("不合法序列");
        }

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    /**
     * 时间复杂度计算：O(N^2)
     * 共有N个节点，每次构建需要循环查找该节点，时间复杂度为O(N)
     * 所以时间复杂度：O(N^2)
     *
     * @param preorder
     * @param preLeft
     * @param preRight
     * @param inorder
     * @param inLeft
     * @param inRight
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        // 1.根据前序序列找到根节点
        int rootValue = preorder[preLeft];
        TreeNode rootNode = new TreeNode(rootValue);
        // 2.根据中序序列划分左右子树
        int curRoot = inLeft;
        while (curRoot <= inRight) {
            if (inorder[curRoot] == rootValue) {
                break;
            }
            curRoot++;
        }
        // 不合法序列
        if ((curRoot == inLeft && inorder[curRoot] != rootValue) || curRoot > inRight) {
            throw new IllegalArgumentException("不合法序列");
        }
        // 左子树长度
        int leftLength = curRoot - inLeft;
        // 3.递归构建左节点
        if (leftLength > 0) {
            rootNode.left = buildTree(preorder, preLeft + 1, preLeft + leftLength, inorder, inLeft, curRoot - 1);
        }
        // 4.递归构建右节点
        if (curRoot < inRight) {
            rootNode.right = buildTree(preorder, preLeft + leftLength + 1, preRight, inorder, curRoot + 1, inRight);
        }

        return rootNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private void printByLevel(TreeNode head) {
        if (null == head) {
            return;
        }
        TreeNode nextPrint = head, curPrint = head;
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(head);
        List<Integer> list = null;

        while (!treeNodes.isEmpty()) {
            if (null == list) {
                list = new ArrayList<>();
            }

            head = treeNodes.poll();
            list.add(head.val);
            if (head.left != null) {
                treeNodes.add(head.left);
                nextPrint = head.left;
            }
            if (head.right != null) {
                treeNodes.add(head.right);
                nextPrint = head.right;
            }
            if (head == curPrint) {
                curPrint = nextPrint;
                System.out.println(list);
                list = null;
            }
        }
    }
}