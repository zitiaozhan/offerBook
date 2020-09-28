/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item46;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/9/28
 */
public class NumberTranslation3 {

    public int translateNum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        // 数组长度
        int length = chars.length;

        // 初始化
        int[] dp = new int[length];
        dp[length - 1] = 1;

        for (int i = length - 2; i >= 0; i--) {
            int curNum = chars[i] - '0';
            int nextNum = chars[i + 1] - '0';
            int number = curNum * 10 + nextNum;

            int lastElement = i + 2 > length - 1 ? 1 : dp[i + 2];
            if (number >= 10 && number < 26) {
                dp[i] = dp[i + 1] + lastElement;
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
    }

    public static void main(String... args) {
        NumberTranslation3 translation3 = new NumberTranslation3();
        System.out.println(translation3.translateNum(15));
        System.out.println(translation3.translateNum(75));
        System.out.println(translation3.translateNum(258));
        System.out.println(translation3.translateNum(31257));
        System.out.println(translation3.translateNum(12258));
        System.out.println(translation3.translateNum(1068385902));
    }

}