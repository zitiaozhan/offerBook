/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item58;

/**
 * P286
 * 左旋转字符串
 *
 * @author xingye
 * @created 2020/9/5
 */
public class LeftRotateString {

    public static void main(String... args) {
        LeftRotateString rotateString = new LeftRotateString();
        System.out.println(rotateString.leftRotateString("abcdefg", 2));
        System.out.println(rotateString.leftRotateString("abcdefg", 7));
        System.out.println(rotateString.leftRotateString("abcdefg", 6));
        System.out.println(rotateString.leftRotateString("123 456 789 0", 6));
    }

    private String leftRotateString(String target, int leftNum) {
        if (null == target || 2 > target.length() || leftNum < 1 || leftNum >= target.length()) {
            return target;
        }

        // 按照单词旋转的逻辑将字符串氛围两部分旋转
        char[] chars = target.toCharArray();
        // 1.整体旋转字符串
        reverseString(chars, 0, chars.length - 1);
        // 2.按照leftNum分两部分旋转字符串
        reverseString(chars, 0, chars.length - leftNum - 1);
        reverseString(chars, chars.length - leftNum, chars.length - 1);
        return new String(chars);
    }

    private void reverseString(char[] chars, int left, int right) {
        if (left == right) {
            return;
        }

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }

}