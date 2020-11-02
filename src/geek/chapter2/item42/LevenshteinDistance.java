/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item42;

import java.util.Arrays;

/**
 * 编辑距离
 *
 * @author xinyeguo
 * @created 2020/11/2
 */
public class LevenshteinDistance {

    /**
     * 莱文斯坦距离：莱文斯坦距离允许增加、删除、替换字符这三个编辑操作
     * 表示两个字符串差异的大小
     *
     * @param src     原字符串
     * @param compare 对比字符串
     * @return 编辑距离
     */
    private int levenshteinDistance(String src, String compare) {
        char[] srcChars = src.toCharArray();
        char[] compareChars = compare.toCharArray();

        int[][] minDist = new int[srcChars.length][compareChars.length];
        // 初始化状态转移表，第一行
        for (int i = 0; i < srcChars.length; i++) {
            if (srcChars[i] == compareChars[0]) {
                minDist[0][i] = 0;
            } else if (i != 0) {
                minDist[0][i] = minDist[0][i - 1] + 1;
            } else {
                minDist[0][i] = 1;
            }
        }
        // 初始化状态转移表，第一列
        for (int i = 1; i < compareChars.length; i++) {
            minDist[i][0] = minDist[i - 1][0] + 1;
        }
        // 递推公式:
        // 1.字符相等: f(i,j) = min(f(i-1,j-1), f(i-1,j) + 1, f(i,j-1) + 1)
        // 2.字符不等: f(i,j) = min(f(i-1,j-1) + 1, f(i-1,j) + 1, f(i,j-1) + 1)
        for (int i = 1; i < srcChars.length; i++) {
            for (int j = 1; j < compareChars.length; j++) {
                if (srcChars[j] == compareChars[i]) {
                    minDist[i][j] = min(minDist[i - 1][j - 1], minDist[i - 1][j] + 1, minDist[i][j - 1] + 1);
                } else {
                    minDist[i][j] = min(minDist[i - 1][j - 1] + 1, minDist[i - 1][j] + 1, minDist[i][j - 1] + 1);
                }
            }
        }

        for (int i = 0; i < srcChars.length; i++) {
            System.out.println(Arrays.toString(minDist[i]));
        }

        return minDist[compareChars.length - 1][srcChars.length - 1];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public static void main(String... args) {
        LevenshteinDistance editDistance = new LevenshteinDistance();
        System.out.println(editDistance.levenshteinDistance("mtacnu", "mitcmu"));
    }

}