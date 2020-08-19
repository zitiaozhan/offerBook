/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item33;

/**
 * P179
 * 二叉搜索树的后序遍历序列
 *
 * @author xingye
 * @created 2020/8/18
 */
public class AfterWordSequence {

    public static void main(String... args) {
        AfterWordSequence afterWordSequence = new AfterWordSequence();
        System.out.println(afterWordSequence.afterWordSequence(new int[]{1, 2, 5, 10, 6, 9, 4, 3}));
    }

    public boolean afterWordSequence(int[] nums) {
        if (null == nums || nums.length == 0) {
            return true;
        }

        return afterWordSequence(nums, 0, nums.length - 1);
    }

    private boolean afterWordSequence(int[] nums, int left, int right) {
        if (left >= right) {
            return true;
        }

        int root = nums[right];
        // 左子树的右边界
        int leftRight;
        for (leftRight = left; leftRight < right; leftRight++) {
            if (nums[leftRight] > root) {
                break;
            }
        }

        for (int i = leftRight; i < right; i++) {
            if (nums[i] < root) {
                // 右子树都比根节点值更大
                return false;
            }
        }

        boolean leftTree = afterWordSequence(nums, left, leftRight - 1);
        boolean rightTree = afterWordSequence(nums, leftRight, right - 1);

        return leftTree && rightTree;
    }

}