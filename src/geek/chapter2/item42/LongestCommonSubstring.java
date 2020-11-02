/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item42;

import java.util.Arrays;

/**
 * 最长公共子串
 * 表示两个字符串相似程度的大小
 * 只允许增加、删除字符这两个编辑操作
 *
 * @author xinyeguo
 * @created 2020/11/2
 */
public class LongestCommonSubstring {

    private int longestCommonSubstring(String src, String compare) {
        char[] srcChars = src.toCharArray();
        char[] compareChars = compare.toCharArray();

        int[][] dp = new int[srcChars.length][compareChars.length];
        // 初始化第一行
        for (int i = 0; i < srcChars.length; i++) {
            if (srcChars[i] == compareChars[0]) {
                dp[0][i] = 1;
            } else if (i != 0) {
                dp[0][i] = dp[0][i - 1];
            } else {
                dp[0][i] = 0;
            }
        }
        // 初始化第一列
        for (int i = 1; i < compareChars.length; i++) {
            if (compareChars[i] == srcChars[0]) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        // 递推公式：
        // 1.两字符相等: f(i,j)=max(f(i-1,j),f(i,j-1),f(i-1,j-1)+1)
        // 2.两字符不等: f(i,j)=max(f(i-1,j),f(i,j-1),f(i-1,j-1))
        for (int i = 1; i < compareChars.length; i++) {
            for (int j = 1; j < srcChars.length; j++) {
                if (compareChars[i] == srcChars[j]) {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1] + 1);
                } else {
                    dp[i][j] = max(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                }
            }
        }

        for (int i = 0; i < compareChars.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[compareChars.length - 1][srcChars.length - 1];
    }

    private int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String... args) {
        LongestCommonSubstring commonSubstring = new LongestCommonSubstring();
        System.out.println(commonSubstring.longestCommonSubstring("mtacnu", "mitcmu"));
    }

}