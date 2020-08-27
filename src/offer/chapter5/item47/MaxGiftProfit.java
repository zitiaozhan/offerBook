/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item47;

/**
 * P233
 * 礼物的最大价值
 *
 * @author xingye
 * @created 2020/8/27
 */
public class MaxGiftProfit {

    private int maxGiftProfit(int[][] profit) {
        if (null == profit || profit.length == 0) {
            return 0;
        }

        // 动态规划
        // 公式：f(m, n) = max(f(m - 1, n), f(m, n - 1)) + cur
        int[] dp = new int[profit[0].length];
        for (int row = 0; row < profit.length; row++) {
            for (int col = 0; col < profit[row].length; col++) {
                int curProfit = profit[row][col];
                if (col == 0) {
                    // 第一列的情况
                    dp[col] = row == 0 ? curProfit : dp[col] + curProfit;
                } else {
                    dp[col] = Math.max(dp[col - 1], dp[col]) + curProfit;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String... args) {
        MaxGiftProfit maxGiftProfit = new MaxGiftProfit();
        System.out.println(maxGiftProfit.maxGiftProfit(new int[][]{{1, 10, 3, 8}, {12, 2, 9, 6}, {5, 7, 4, 11}, {3, 7, 16, 5}}));
        System.out.println(maxGiftProfit.maxGiftProfit(new int[][]{{1, 10, 3, 8}}));
        System.out.println(maxGiftProfit.maxGiftProfit(new int[][]{{1}}));
        System.out.println(maxGiftProfit.maxGiftProfit(new int[][]{{1, 31}}));
        System.out.println(maxGiftProfit.maxGiftProfit(new int[][]{{1}, {2}, {3}, {6}}));
    }
}