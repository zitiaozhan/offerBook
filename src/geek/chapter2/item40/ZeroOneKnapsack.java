/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item40;

/**
 * 0-1背包
 * 对于一组不同重量、不可分割的物品，我们需要选择一些装入背包，
 * 在满足背包最大重量限制的前提下，背包中物品总重量的最大值是多少呢？
 *
 * @author xingye
 * @created 2020/10/28
 */
public class ZeroOneKnapsack {

    /**
     * 使用二维数组保存状态
     *
     * @param maxWeight 背包最大载重
     * @param weights   物品重量
     * @return 最大值
     */
    public int knapsack(int maxWeight, int[] weights) {
        boolean[][] dp = new boolean[weights.length][maxWeight + 1];
        // 第一个物品选择装载或者不装载
        if (weights[0] <= maxWeight) {
            dp[0][weights[0]] = true;
        }
        dp[0][0] = true;

        for (int i = 1; i < weights.length; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // 不装载该物品
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
            for (int j = 0; j <= maxWeight - weights[i]; j++) {
                // 装载该物品
                if (dp[i - 1][j]) {
                    dp[i][j + weights[i]] = true;
                }
            }
        }

        for (int i = maxWeight; i >= 0; i--) {
            if (dp[weights.length - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    public int knapsackOpt(int maxWeight, int[] weights) {
        boolean[] dp = new boolean[maxWeight + 1];
        int number = weights.length;

        // 初始化状态
        dp[0] = true;
        if (weights[0] <= maxWeight) {
            dp[weights[0]] = true;
        }

        for (int i = 1; i < number; i++) {
            for (int j = maxWeight - weights[i]; j >= 0; j--) {
                // 装载该物品，因为是一维数组，所以不装载的不用显式赋值
                if (dp[j]) {
                    dp[j + weights[i]] = true;
                }
            }
        }

        for (int i = maxWeight; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}