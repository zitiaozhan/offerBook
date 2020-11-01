/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item41;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 假设我们有几种不同币值的硬币 v1，v2，……，vn（单位是元）。
 * 如果我们要支付 w 元，求最少需要多少个硬币。
 * 比如，我们有 3 种不同的硬币，1 元、3 元、5 元，我们要支付 9 元，最少需要 3 个硬币（3 个 3 元的硬币）。
 *
 * @author xinyeguo
 * @created 2020/10/30
 */
public class CoinMoney {

    private List<Integer> coinPlan(int[] coinTypes, int money) {
        // 硬币面值排序
        Arrays.sort(coinTypes);
        List<Integer> plans = new ArrayList<>();
        boolean planRes = coinPlanCore(coinTypes, money, plans);
        if (planRes) {
            return plans;
        }
        return null;
    }

    private boolean coinPlanCore(int[] coinTypes, int money, List<Integer> plans) {
        if (money == 0) {
            return true;
        }
        if (money < coinTypes[0]) {
            // 低于最低面值
            return false;
        }

        // 指数级时间复杂度
        for (int i = coinTypes.length - 1; i >= 0; i--) {
            if (money >= coinTypes[i]) {
                plans.add(coinTypes[i]);

                money -= coinTypes[i];
                boolean planCore = coinPlanCore(coinTypes, money, plans);
                if (planCore) {
                    return true;
                }
                money += coinTypes[i];

                plans.remove(plans.size() - 1);
            }
        }
        return false;
    }

    private int coinPlan2(int[] coinTypes, int money) {
        int[] dp = new int[money + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        // 按照硬币面值排序
        Arrays.sort(coinTypes);
        // 复杂度O(M * N), 递推公式: f(n) = f(n - max(coinTypes)) + 1
        for (int i = 1; i <= money; i++) {
            // 从小问题开始解决，避免重复计算
            for (int j = coinTypes.length - 1; j >= 0; j--) {
                if (coinTypes[j] <= i && dp[i - coinTypes[j]] >= 0) {
                    dp[i] = dp[i - coinTypes[j]] + 1;
                    break;
                }
            }
        }

        // 最少需要多少枚硬币
        return dp[money];
    }

    public static void main(String... args) {
        CoinMoney coinMoney = new CoinMoney();
        System.out.println(coinMoney.coinPlan(new int[]{1, 3, 5}, 9));
        System.out.println(String.format("最少需要%d枚硬币", coinMoney.coinPlan2(new int[]{1, 3, 5}, 9)));
        System.out.println(coinMoney.coinPlan(new int[]{1, 2, 5, 8, 10, 50}, 399));
        System.out.println(String.format("最少需要%d枚硬币", coinMoney.coinPlan2(new int[]{1, 2, 5, 8, 10, 50}, 399)));
        System.out.println(coinMoney.coinPlan(new int[]{1, 2, 5, 8, 10, 50}, 376));
        System.out.println(String.format("最少需要%d枚硬币", coinMoney.coinPlan2(new int[]{1, 2, 5, 8, 10, 50}, 376)));
        System.out.println(coinMoney.coinPlan(new int[]{1, 2, 5, 8, 10, 50}, 1));
        System.out.println(String.format("最少需要%d枚硬币", coinMoney.coinPlan2(new int[]{1, 2, 5, 8, 10, 50}, 1)));
    }

}