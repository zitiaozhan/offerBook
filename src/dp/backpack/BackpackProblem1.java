/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package dp.backpack;

/**
 * 背包问题1
 * 在n个物品中挑选若干物品装入背包，最多能装多满？假设背包的大小为m，每个物品的大小为A[i]。
 * 你不可以将物品进行切割。
 *
 * @author xinyeguo
 * @created 2020/11/5
 */
public class BackpackProblem1 {

    public int backpackProblem(int room, int[] sizes) {
        boolean[] dp = new boolean[room + 1];
        dp[0] = true;

        for (int i = 0; i < sizes.length; i++) {
            for (int j = room - sizes[i]; j >= 0; j--) {
                if (dp[j]) {
                    dp[j + sizes[i]] = true;
                }
            }
        }

        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String... args) {
        BackpackProblem1 backpackProblem1 = new BackpackProblem1();
        System.out.println(backpackProblem1.backpackProblem(10, new int[]{3, 4, 8, 5}));
        System.out.println(backpackProblem1.backpackProblem(12, new int[]{2,3,5,7}));
    }

}