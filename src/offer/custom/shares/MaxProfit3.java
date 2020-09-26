/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.shares;

/**
 * 123. 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/26
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (null == prices || prices.length < 2) {
            return 0;
        }

        // 完成一次和完成两次的最大收益
        int[] oneProfit = new int[prices.length];
        int twoProfit = 0, oneMin = prices[0];

        // 递推公式：
        // 一次交易：f(n)=max(f(n-1),f(n-1)+diff)
        // 两次交易：g(n)=max(g(n-1),f(n-x)+diff)
        for (int i = 1; i < prices.length; i++) {
            // 1.更新交易一次收益
            if (prices[i] > oneMin) {
                oneProfit[i] = Math.max(oneProfit[i - 1], prices[i] - oneMin);
            } else {
                oneProfit[i] = oneProfit[i - 1];
                oneMin = prices[i];
            }

            // 2.更新交易两次收益
            if (i > 2) {
                int index = i - 2;
                while (index > 0) {
                    if (prices[i] > prices[index + 1]) {
                        twoProfit = Math.max(twoProfit, oneProfit[index] + (prices[i] - prices[index + 1]));
                    }
                    index--;
                }
            }
        }

        return Math.max(oneProfit[oneProfit.length - 1], twoProfit);
    }

    // 题解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/yi-ge-tong-yong-fang-fa-tuan-mie-6-dao-gu-piao-wen/
    public int maxProfit2(int[] prices) {
        // dp后面含义：i表示第几天，第二位表示可购买次数，第三位表示0（当前未持有股票）1(当前持有股票)
        int dp_i10 = 0, dp_i20 = 0;
        int dp_i11 = Integer.MIN_VALUE, dp_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            dp_i20 = Math.max(dp_i20, dp_i21 + price);
            dp_i21 = Math.max(dp_i21, dp_i10 - price);

            dp_i10 = Math.max(dp_i10, dp_i11 + price);
            dp_i11 = Math.max(dp_i11, -price);
        }
        return dp_i20;
    }

    public static void main(String... args) {
        MaxProfit3 maxProfit3 = new MaxProfit3();
        System.out.println(maxProfit3.maxProfit2(new int[]{6, 1, 3, 2, 4, 7}));
        System.out.println(maxProfit3.maxProfit2(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(maxProfit3.maxProfit2(new int[]{1, 2, 3, 4, 5}));
        System.out.println(maxProfit3.maxProfit2(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit3.maxProfit2(new int[]{2, 1, 4, 5, 2, 9, 7}));
        System.out.println(maxProfit3.maxProfit2(new int[]{1, 2, 4, 2, 5, 7, 2, 4, 9, 0}));
        System.out.println(maxProfit3.maxProfit2(new int[]{6, 5, 4, 8, 6, 8, 7, 8, 9, 4, 5}));
    }
}