/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.custom.shares;

/**
 * 122. 买卖股票的最佳时机 II
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/26
 */
public class MaxProfit2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        if (null == prices || prices.length < 2) {
            return maxProfit;
        }

        maxProfit = Math.max((prices[1] - prices[0]), maxProfit);
        for (int i = 2; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                maxProfit = maxProfit + diff;
            }
        }
        return maxProfit;
    }

    public static void main(String... args) {
        MaxProfit2 maxProfit2 = new MaxProfit2();
        System.out.println(maxProfit2.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit2.maxProfit(new int[]{1, 2, 3, 4, 5}));
    }
}