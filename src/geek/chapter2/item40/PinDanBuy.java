/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item40;

import java.util.ArrayList;
import java.util.List;

/**
 * 拼单购买
 * 比如“满 200 元减 50 元”。假设你女朋友的购物车中有 n 个（n>100）想买的商品，
 * 她希望从里面选几个，在凑够满减条件的前提下，让选出来的商品价格总和最大程度地接近满减条件（200 元），
 * 这样就可以极大限度地“薅羊毛”。作为程序员的你，能不能编个代码来帮她搞定呢？
 *
 * @author xingye
 * @created 2020/10/28
 */
public class PinDanBuy {
    public int pinDanBuy(int discount, int[] prices) {
        boolean[] dp = new boolean[discount * 3 + 1];
        int number = prices.length;

        dp[0] = true;
        if (prices[0] <= discount * 3) {
            dp[prices[0]] = true;
        }

        for (int i = 1; i < number; i++) {
            for (int j = 3 * discount - prices[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + prices[i]] = true;
                }
            }
        }

        for (int i = discount; i < 3 * discount; ++i) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }

    private void pinDanBuy2(int discount, int[] prices) {
        int number = prices.length;
        boolean[][] dp = new boolean[number][discount * 3 + 1];

        // 初始状态
        // 不买第一件物品
        dp[0][0] = true;
        if (prices[0] <= 3 * discount) {
            // 买第一件物品
            dp[0][prices[0]] = true;
        }

        for (int i = 1; i < number; i++) {
            // 不买第i件物品
            for (int j = 0; j <= discount * 3; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }

            // 买该物品
            for (int j = 0; j <= discount * 3 - prices[i]; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j + prices[i]] = true;
                }
            }
        }

        int result = -1;
        for (int i = discount; i <= discount * 3; i++) {
            if (dp[number - 1][i]) {
                result = i;
                break;
            }
        }
        System.out.println("result = " + result);
        List<Integer> buys = new ArrayList<>();

        int mon = result;
        for (int i = number - 1; i > 0; i--) {
            if (dp[i - 1][mon - prices[i]]) {
                buys.add(prices[i]);
                mon = mon - prices[i];
            }
        }
        if (mon > 0) {
            buys.add(prices[0]);
        }
        System.out.println("buys = " + buys);
    }

    public static void main(String... args) {
        PinDanBuy pinDanBuy = new PinDanBuy();
        System.out.println(pinDanBuy.pinDanBuy(210, new int[]{23, 34, 45, 34, 18, 22, 99, 11, 35}));
        pinDanBuy.pinDanBuy2(210, new int[]{23, 34, 45, 34, 18, 22, 99, 11, 35});
    }
}