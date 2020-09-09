/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item67;

/**
 * 数字转字符串
 *
 * @author xingye
 * @created 2020/9/9
 */
public class NumberToString {

    private Integer strToInt(String target) {
        if (null == target || 0 == target.length()) {
            return null;
        }

        char[] chars = target.toCharArray();
        // 正负号只会出现在第一位
        boolean negativeFlag = false;
        long result = 0;
        int bitSize = chars.length;
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if ('-' == aChar || '+' == aChar) {
                bitSize--;
                if (i == 0 && bitSize > 0) {
                    negativeFlag = '-' == aChar;
                } else {
                    throw new IllegalArgumentException("包含错误的字符");
                }
            } else if (aChar >= '0' && aChar <= '9') {
                result += (aChar - '0') * Math.pow(10, bitSize - 1);
            } else {
                throw new IllegalArgumentException("包含错误的字符");
            }
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            throw new IllegalArgumentException("整数溢出");
        }
        return (int) (negativeFlag ? -1 * result : result);
    }

    public static void main(String... args) {
        NumberToString numberToString = new NumberToString();
        System.out.println(numberToString.strToInt("100"));
        System.out.println(numberToString.strToInt("-100"));
        System.out.println(numberToString.strToInt("+100"));
        System.out.println(numberToString.strToInt("+100"));
        System.out.println(numberToString.strToInt("53335353535353"));
    }
}