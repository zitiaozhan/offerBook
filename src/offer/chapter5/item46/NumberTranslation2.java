/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item46;

/**
 * P46
 * 把数字翻译成字符串
 * DONE:重做标签
 *
 * @author xingye
 * @created 2020/9/20
 */
public class NumberTranslation2 {
    private int translation(int number) {
        if (number < 0) {
            return 0;
        }

        return countTranslate(String.valueOf(number).toCharArray());
    }

    private int countTranslate(char[] chars) {
        int count = 0;
        int[] counts = new int[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i == chars.length - 1) {
                count = 1;
            } else {
                count = counts[i + 1];
            }

            if (i < chars.length - 1) {
                int cur = chars[i] - '0';
                int right = chars[i + 1] - '0';
                int join = cur * 10 + right;
                if (join >= 10 && join < 26) {
                    if (i + 2 < chars.length - 1) {
                        count += counts[i + 2];
                    } else {
                        count += 1;
                    }
                }
            }
            counts[i] = count;
        }
        return counts[0];
    }

    public static void main(String... args) {
        NumberTranslation2 translation2 = new NumberTranslation2();
        System.out.println(translation2.translation(12258));
        System.out.println(translation2.translation(31257));
    }
}