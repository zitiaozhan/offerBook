/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item40;

import java.util.Arrays;

/**
 * “杨辉三角”不知道你听说过吗？我们现在对它进行一些改造。
 * 每个位置的数字可以随意填写，经过某个数字只能到达下面一层相邻的两个数字。
 * 假设你站在第一层，往下移动，我们把移动到最底层所经过的所有数字之和，定义为路径的长度。
 * 请你编程求出从最高层移动到最底层的最短路径长度。
 * https://time.geekbang.org/column/article/74788
 *
 * @author xingye
 * @created 2020/10/30
 */
public class YanghuiTriangle {

    private void findShortestPath(int[][] origins) {
        // 从(0,0)到(x,len-1-x),只能向右或向下,lines=columns
        int n = origins.length;
        int[] dp = new int[n];

        // 初始化状态
        dp[0] = origins[0][0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + origins[0][i];
        }

        // 递推
        for (int line = 1; line < n; line++) {
            for (int column = 0; column < origins[line].length; column++) {
                if (column == 0) {
                    dp[column] = origins[line][column] + dp[column];
                    continue;
                }
                dp[column] = origins[line][column] + Math.min(dp[column - 1], dp[column]);
            }
        }

        System.out.println("dp = " + Arrays.toString(dp));
    }

    public int yanghuiTriangle(int[][] matrix) {
        int length = matrix.length;
        // 用于存储每一层的状态
        int[] min = new int[length + 1];
        for (int i = length - 1; i >= 0; i--) {
            int[] rawNums = matrix[i];
            int rowLength = rawNums.length;
            for (int j = 0; j < rowLength; j++) {
                min[j] = Math.min(min[j], min[j + 1]) + rawNums[j];
            }
        }
        return min[0];
    }

    public static void main(String... args) {
        YanghuiTriangle triangle = new YanghuiTriangle();
        int[][] origins = new int[][]{{5, 8, 4, 1, 5}, {7, 3, 6, 4}, {2, 9, 9}, {4, 7}, {2}};
        triangle.findShortestPath(origins);
    }
}