/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item33;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * @author xingye
 * @created 2020/12/8
 */
public class VerifyPostorder2 {

    public boolean verifyPostorder(int[] postorder) {
        if (null == postorder) {
            return true;
        }

        return verifySubTree(postorder, 0, postorder.length - 1);
    }

    private boolean verifySubTree(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }

        int rootVal = postorder[right];

        int rightStart = left;
        for (; rightStart < right; rightStart++) {
            if (postorder[rightStart] > rootVal) {
                break;
            }
        }

        for (int i = rightStart; i < right; i++) {
            if (postorder[i] <= rootVal) {
                return false;
            }
        }
        return verifySubTree(postorder, left, rightStart - 1) && verifySubTree(postorder, rightStart, right - 1);
    }

    public static void main(String... args) {
        VerifyPostorder2 postorder2 = new VerifyPostorder2();
        boolean b = postorder2.verifyPostorder(new int[]{1, 2, 5, 10, 6, 9, 4, 3});
        System.out.println("b = " + b);
    }

}