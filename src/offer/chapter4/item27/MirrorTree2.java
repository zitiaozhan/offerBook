/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item27;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * P157
 * 剑指 Offer 27. 二叉树的镜像
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author xingye
 * @created 2020/9/15
 */
public class MirrorTree2 {

    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = mirrorTree(root.right);
        head.right = mirrorTree(root.left);
        return head;
    }

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private void printLine(TreeNode head) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(head);

        List<Integer> nums = new ArrayList<>();
        TreeNode curLine = head, nextLine = head;
        while (!nodeQueue.isEmpty()) {
            head = nodeQueue.poll();
            nums.add(head.val);

            if (null != head.left) {
                nodeQueue.add(head.left);
                nextLine = head.left;
            }
            if (null != head.right) {
                nodeQueue.add(head.right);
                nextLine = head.right;
            }

            if (curLine == head) {
                System.out.println(nums);
                nums = new ArrayList<>();
                curLine = nextLine;
            }
        }
    }

    public static void main(String... args) {
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(2);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node3.right = node5;

        MirrorTree2 mirrorTree2 = new MirrorTree2();
        TreeNode head = mirrorTree2.mirrorTree(node1);
        mirrorTree2.printLine(head);
    }

}