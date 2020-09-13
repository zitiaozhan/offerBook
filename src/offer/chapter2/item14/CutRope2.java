/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item14;

/**
 * P96
 * 剪绳子
 *
 * @author xingye
 * @created 2020/9/13
 */
public class CutRope2 {

    private int cutRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        for (int i = 4; i <= n; i++) {
            dp[i] = Math.max(2 * dp[i - 2], 3 * dp[i - 3]);
        }
        return dp[n];
    }

    public static void main(String... args) {
        CutRope2 cutRope2 = new CutRope2();
        System.out.println(cutRope2.cutRope(7));
        System.out.println(cutRope2.cutRope(8));
    }
}