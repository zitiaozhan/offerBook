/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item60;

import java.util.Arrays;

/**
 * P294
 * N个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * @author xingye
 * @created 2020/9/6
 */
public class NDicePoint {
    int maxPoint = 6;

    private double[] dicePoint(int n) {
        // 数字范围：n ~ 6n
        // 公式：f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6)
        if (n < 1) {
            return null;
        }

        // 数组保存点数出现次数
        int[][] pointPresent = new int[2][maxPoint * n + 1];
        int arrIndex = 0;
        // 初始化,当n=1时
        for (int i = 1; i <= maxPoint; i++) {
            pointPresent[arrIndex][i] = 1;
        }
        // 向下推演
        for (int i = 2; i <= n; i++) {
            // 另一个数组清空数据
            Arrays.fill(pointPresent[1 - arrIndex], 0);
            // 求解和为sum的次数
            for (int sum = 2; sum <= maxPoint * n; sum++) {
                pointPresent[1 - arrIndex][sum] = 0;
                // 本次掷出的点数
                for (int curPoint = 1; curPoint <= sum && curPoint <= maxPoint; curPoint++) {
                    // f(n)=f(n-1)+f(n-2)+f(n-3)+f(n-4)+f(n-5)+f(n-6)
                    pointPresent[1 - arrIndex][sum] += pointPresent[arrIndex][sum - curPoint];
                }
            }

            // 数组切换
            arrIndex = 1 - arrIndex;
        }

        // 求得概率
        double total = Math.pow(maxPoint, n);
        double[] result = new double[maxPoint * n - n + 1];
        int index = 0;
        for (int i = n; i <= maxPoint * n; i++) {
            result[index++] = pointPresent[arrIndex][i] / total;
        }
        return result;
    }

    public static void main(String... args) {
        NDicePoint dicePoint = new NDicePoint();
        System.out.println(Arrays.toString(dicePoint.dicePoint(1)));
        System.out.println(Arrays.toString(dicePoint.dicePoint(2)));
    }

}