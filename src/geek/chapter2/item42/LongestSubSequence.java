/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter2.item42;

/**
 * 我们有一个数字序列包含 n 个不同的数字，如何求出这个序列中的最长递增子序列长度？
 * 比如 2, 9, 3, 6, 5, 1, 7 这样一组数字序列，它的最长递增子序列就是 2, 3, 5, 7，所以最长递增子序列的长度是 4。
 *
 * @author xingye
 * @created 2020/11/2
 */
public class LongestSubSequence {

    public int longestSubSequence(int[] nums) {
        // dp[i]表示以下标i结尾字符串的最长递增子序列长度
        int[] dp = new int[nums.length];
        dp[0] = 1;

        // 递推公式：last<cur
        // nums[cur] > nums[last]时, f(cur)=max(f(cur),f(last)+1)
        // nums[cur] <= nums[last]时, f(cur)=max(f(cur),f(cur-1))
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Math.max(dp[i], dp[i - 1]);
                }
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String... args) {
        LongestSubSequence subSequence = new LongestSubSequence();
        System.out.println(subSequence.longestSubSequence(new int[]{2, 9, 3, 6, 5, 1, 7}));
        System.out.println(subSequence.longestSubSequence(new int[]{9, 6, 5, 4, 2, 1}));
    }

}