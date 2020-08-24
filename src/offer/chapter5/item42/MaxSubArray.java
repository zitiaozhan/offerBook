/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * P218
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author xingye
 * @created 2020/8/24
 */
public class MaxSubArray {

    /**
     * 贪心算法解法 O(N)
     * 动态规划公式：
     * f(i)=sum(f(i-1))+f(i) ,当sum(f(i-1))>0
     * f(i)=f(i)             ,当sum(f(i-1))<=0
     *
     * @param nums 输入数组
     */
    public int maxSubArray(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }

        int maxSum = Integer.MIN_VALUE;
        int curSum = 0;
        for (int num : nums) {
            if (curSum <= 0) {
                // 前面的和相加相遇等于0，再加上当前数字还不如仅有当前数
                curSum = num;
            } else {
                curSum += num;
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }

    public static void main(String... args) {
        MaxSubArray maxSubArray = new MaxSubArray();
        System.out.println(maxSubArray.maxSubArray(new int[]{3, 1, -2, 6, 0, -5}));
        System.out.println(maxSubArray.maxSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}