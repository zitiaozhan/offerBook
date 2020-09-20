/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item47;

/**
 * P47
 * 礼物的最大价值
 *
 * @author xingye
 * @created 2020/9/20
 */
public class MaxGiftProfit2 {

    private int maxGiftProfit(int[][] nums) {
        if (null == nums || 0 == nums.length || 0 == nums[0].length) {
            return 0;
        }

        int[] maxProfit = new int[nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (i == 0 && j == 0) {
                    maxProfit[j] = nums[i][j];
                } else if (i == 0) {
                    maxProfit[j] = maxProfit[j - 1] + nums[i][j];
                } else if (j == 0) {
                    maxProfit[j] = maxProfit[j] + nums[i][j];
                } else {
                    maxProfit[j] = Math.max(maxProfit[j - 1], maxProfit[j]) + nums[i][j];
                }
            }
        }
        return maxProfit[maxProfit.length - 1];
    }

    public static void main(String... args) {
        MaxGiftProfit2 giftProfit2 = new MaxGiftProfit2();
        System.out.println(giftProfit2.maxGiftProfit(new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}}));
    }

}