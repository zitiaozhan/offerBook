/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item58;

/**
 * P284
 * 翻转单词顺序
 *
 * @author xingye
 * @created 2020/9/5
 */
public class ReverseString {

    public static void main(String... args) {
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverseString(" "));
        System.out.println(reverseString.reverseString("  "));
        System.out.println(reverseString.reverseString(" ha ha !"));
        System.out.println(reverseString.reverseString("a student"));
        System.out.println(reverseString.reverseString("I am a student."));
        System.out.println(reverseString.reverseString("With a bit of guidance, anyone can become a Java programmer."));
    }

    private String reverseString(String target) {
        if (null == target || 2 > target.length()) {
            return target;
        }
        char[] chars = target.toCharArray();
        // 1.先整体翻转
        reverseString(chars, 0, chars.length - 1);
        // 2.然后分单词翻转
        int left = 0, right = left;
        while (left < chars.length && right < chars.length) {
            char aChar = chars[right];
            if (aChar == ' ') {
                // 等于空格
                reverseString(chars, left, right - 1);
                left = right + 1;
                right = left;
            } else {
                right++;
            }
        }
        // 最后面没有空格的单词翻转
        if (left < chars.length) {
            reverseString(chars, left, chars.length - 1);
        }

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