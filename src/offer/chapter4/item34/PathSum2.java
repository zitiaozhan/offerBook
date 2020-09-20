/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item34;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 * @author xingye
 * @created 2020/9/17
 */
public class PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (null == root) {
            return new ArrayList<>();
        }

        // sum 可为负数
        List<List<Integer>> result = new ArrayList<>();
        pathSumCore(root, sum, result, new ArrayList<>());
        return result;
    }

    // 时间/空间 复杂度：O(N)
    private void pathSumCore(TreeNode root, int sum, List<List<Integer>> result, List<Integer> path) {
        if (root != null) {
            // 减去当前节点值，向左右节点寻找路径
            sum = sum - root.val;
            path.add(root.val);
            if (null == root.left && null == root.right && sum == 0) {
                // 该节点为叶子节点，且sum==0
                result.add(new ArrayList<>(path));
                return;
            }

            if (null != root.left) {
                // 从左子树搜索路径
                pathSumCore(root.left, sum, result, path);
                path.remove(path.size() - 1);
            }

            if (null != root.right) {
                // 从右子树搜索路径
                pathSumCore(root.right, sum, result, path);
                path.remove(path.size() - 1);
            }
        }
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