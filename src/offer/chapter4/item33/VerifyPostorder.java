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
 * @created 2020/9/16
 */
public class VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        if (null == postorder || 0 == postorder.length) {
            return true;
        }
        // 递归，根节点在最后
        return verifyPostorderCore(postorder, 0, postorder.length - 1);
    }

    // 时间复杂度：NlogN
    private boolean verifyPostorderCore(int[] postorder, int l, int r) {
        if (l >= r) {
            return true;
        }

        // 1.得到根节点
        int root = postorder[r];
        // 2.根据根节点划分左右节点
        int rightStart;
        for (rightStart = l; rightStart < r; rightStart++) {
            if (postorder[rightStart] > root) {
                break;
            }
        }
        // 3.右子树的数都比根节点的值大
        for (int i = rightStart; i < r; i++) {
            if (postorder[i] < root) {
                return false;
            }
        }

        // 4.左右子树是否为搜索树
        return verifyPostorderCore(postorder, l, rightStart - 1) && verifyPostorderCore(postorder, rightStart, r - 1);
    }

    public static void main(String... args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        System.out.println(verifyPostorder.verifyPostorder(new int[]{5, 2, -17, -11, 25, 76, 62, 98, 92, 61}));
    }
}