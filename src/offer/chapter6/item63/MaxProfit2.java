/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item63;

/**
 * 股票的最大利润
 *
 * @author xingye
 * @created 2020/9/26
 */
public class MaxProfit2 {

    public int maxProfit(int[] nums) {
        int maxProfit = 0;
        if (null == nums || nums.length < 2) {
            return maxProfit;
        }

        // 记录最小值
        int min = nums[0];


        for (int i = 1; i < nums.length; i++) {
            maxProfit = Math.max(maxProfit, nums[i] - min);
            min = Math.min(min, nums[i]);
        }
        return maxProfit;
    }

    public static void main(String... args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[]{9, 11, 8, 5, 7, 12, 16, 14}));
        System.out.println(maxProfit2.maxProfit(new int[]{7, 6, 5, 4, 3, 2}));
    }

}