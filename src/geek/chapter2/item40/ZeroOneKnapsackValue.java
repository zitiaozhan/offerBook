/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item40;

import java.util.Arrays;

/**
 * 0-1 背包问题升级版
 * 对于一组不同重量、不同价值、不可分割的物品，我们选择将某些物品装入背包，
 * 在满足背包最大重量限制的前提下，背包中可装入物品的总价值最大是多少呢？
 *
 * @author xingye
 * @created 2020/10/28
 */
public class ZeroOneKnapsackValue {
    public int getMaxValue(int maxWeight, int[] weights, int[] values) {
        // 下标为重量，值为价值
        int[] dp = new int[maxWeight + 1];
        // 物品数量
        int number = weights.length;

        // 初始化数组，-1表示未被选择过
        Arrays.fill(dp, -1);

        // 第一件物品的装载与否
        dp[0] = 0;
        if (weights[0] <= maxWeight) {
            dp[weights[0]] = values[0];
        }

        for (int i = 1; i < number; i++) {
            // 第i件物品的装载与否
            for (int j = maxWeight - weights[i]; j >= 0; j--) {
                if (dp[j] != -1) {
                    if (dp[j] + values[i] > dp[j + weights[i]]) {
                        dp[j + weights[i]] = dp[j] + values[i];
                    }
                }
            }
        }

        int maxValue = -1;
        System.out.println(Arrays.toString(dp));
        for (int i = 0; i <= maxWeight; i++) {
            maxValue = Math.max(maxValue, dp[i]);
        }
        return maxValue;
    }

    public static void main(String... args) {
        ZeroOneKnapsackValue value = new ZeroOneKnapsackValue();
        System.out.println(value.getMaxValue(29, new int[]{3, 8, 23, 19, 11, 6, 4, 5}, new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}