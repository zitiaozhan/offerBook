/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item42;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * 要求时间复杂度为O(n)。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class MaxSubArray2 {

    public int maxSubArray(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // 等于求连续最大和，但负数相加只会更小，因此要以0作为判断条件
        int res = Integer.MIN_VALUE;
        int curSum = 0;
        int right = 0;
        while (right < nums.length) {
            if (curSum >= 0) {
                // 1.当前和大于0，则加上下当前数
                curSum += nums[right];
            } else {
                // 2.当前和小于0，则当前和等于当前数
                curSum = nums[right];
            }
            res = Math.max(curSum, res);
            right++;
        }
        return res;
    }

    public static void main(String... args) {
        MaxSubArray2 maxSubArray2 = new MaxSubArray2();
        System.out.println(maxSubArray2.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}