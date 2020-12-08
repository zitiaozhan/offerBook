/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item32;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author xingye
 * @created 2020/12/8
 */
public class PrintTreeByZhi {

    private static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }

        TreeNode curLine = root, nextLine = root;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        List<Integer> lineVals = new ArrayList<>();

        boolean leftToR = true;
        while (!nodes.isEmpty()) {
            TreeNode poll = nodes.poll();
            lineVals.add(poll.val);

            if (null != poll.left) {
                nodes.add(poll.left);
                nextLine = poll.left;
            }
            if (null != poll.right) {
                nodes.add(poll.right);
                nextLine = poll.right;
            }

            if (curLine == poll) {
                curLine = nextLine;
                if (!leftToR) {
                    Collections.reverse(lineVals);
                }
                res.add(lineVals);
                lineVals = new ArrayList<>();
                leftToR = !leftToR;
            }
        }
        return res;
    }

}