/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item14;

/**
 * 剪绳子
 * P96
 *
 * @author xingye
 * @created 2020/7/20
 */
public class CutTheRope {
    public static void main(String... args) {
        CutTheRope cutTheRope = new CutTheRope();
        System.out.println(cutTheRope.cutTheRope(8));
    }

    /**
     * 动态规划
     *
     * @param n 长度为N
     * @return 最大乘积长度
     */
    private int cutTheRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] maxEarnings = new int[n + 1];
        maxEarnings[0] = 0;
        maxEarnings[1] = 1;
        maxEarnings[2] = 2;
        maxEarnings[3] = 3;

        // 外层循环：O(N)
        for (int i = 4; i <= n; i++) {
            int max = 0;
            // 内层循环：O(N)
            for (int j = 1; j <= i / 2; j++) {
                max = Math.max(max, maxEarnings[j] * maxEarnings[i - j]);
            }
            maxEarnings[i] = max;
        }
        return maxEarnings[n];
    }
}