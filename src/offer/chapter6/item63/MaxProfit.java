/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item63;

/**
 * P304股票的最大利润
 * 买卖一次该股票最大利润
 *
 * @author xingye
 * @created 2020/9/8
 */
public class MaxProfit {

    // DONE:所有股票类型算法题目
    private int onceMaxProfit(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        // 定义函数 diff(i) 为当卖出价位数组中第i个数字时可能获得的最大利润。
        // 每个数的最大利润为该数字减去前面的最小值
        int min = nums[0];
        int maxDiff = nums[1] - min;
        for (int i = 2; i < nums.length; i++) {
            min = Math.min(min, nums[i - 1]);
            if (nums[i] - min > maxDiff) {
                maxDiff = nums[i] - min;
            }
        }
        return maxDiff;
    }

    public static void main(String... args) {
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.onceMaxProfit(new int[]{10, 8, 4, 2, 0}));
        System.out.println(maxProfit.onceMaxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
    }

}