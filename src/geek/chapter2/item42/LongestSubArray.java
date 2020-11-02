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
public class LongestSubArray {

    public int longestSubArray(int[] nums) {
        // 初始化状态
        int cur = 1;
        int longest = cur;

        // 递推公式：
        // nums[i]>nums[i-1]时: f(n)=f(n-1)+1
        // nums[i]<=nums[i-1]时: f(n)=1
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur = cur + 1;
                longest = Math.max(longest, cur);
            } else {
                cur = 1;
            }
        }
        return cur;
    }

    public static void main(String... args) {
        LongestSubArray subArray = new LongestSubArray();
        System.out.println(subArray.longestSubArray(new int[]{2, 9, 3, 6, 5, 1, 7}));
    }

}