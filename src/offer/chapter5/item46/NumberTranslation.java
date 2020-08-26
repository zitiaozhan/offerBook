/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item46;

/**
 * P231
 * 把数字翻译成字符串
 *
 * @author xingye
 * @created 2020/8/27
 */
public class NumberTranslation {

    private int numberTranslation(int number) {
        if (number < 0) {
            return 0;
        }
        return countNumberTranslation(String.valueOf(number).toCharArray());
    }

    private int countNumberTranslation(char[] chars) {
        int count = 0;
        int[] counts = new int[chars.length];

        for (int index = chars.length - 1; index >= 0; index--) {
            if (index == chars.length - 1) {
                count = 1;
            } else {
                count = counts[index + 1];
            }

            if (index < chars.length - 1) {
                int cur = chars[index] - '0';
                int right = chars[index + 1] - '0';
                int joinNum = cur * 10 + right;
                if (joinNum >= 10 && joinNum <= 25) {
                    // 位于有翻译的两位数之间，可以再次翻译
                    if (index + 1 < chars.length - 1) {
                        count += counts[index + 2];
                    } else if (index + 1 == chars.length - 1) {
                        count += 1;
                    }
                }
            }
            counts[index] = count;
        }
        return counts[0];
    }

    public static void main(String... args) {
        NumberTranslation numberTranslation = new NumberTranslation();
        System.out.println(numberTranslation.numberTranslation(12258));
        System.out.println(numberTranslation.numberTranslation(0));
        System.out.println(numberTranslation.numberTranslation(252625));
    }
}