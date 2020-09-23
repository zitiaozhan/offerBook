/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item58;

/**
 * 左旋转字符串
 *
 * @author xingye
 * @created 2020/9/23
 */
public class LeftRotateString2 {

    private String leftRotateString(String target, int num) {
        if (null == target || num >= target.length()) {
            return target;
        }

        // 整体翻转
        char[] chars = target.toCharArray();
        reverse(chars, 0, chars.length - 1);
        // 分为两部分翻转
        reverse(chars, 0, chars.length - num - 1);
        reverse(chars, chars.length - num, chars.length - 1);
        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = tmp;
        }
    }

    public static void main(String... args) {
        LeftRotateString2 rotateString = new LeftRotateString2();
        System.out.println(rotateString.leftRotateString("abcdefg", 2));
        System.out.println(rotateString.leftRotateString("abcdefg", 7));
        System.out.println(rotateString.leftRotateString("abcdefg", 6));
        System.out.println(rotateString.leftRotateString("123 456 789 0", 6));
    }

}