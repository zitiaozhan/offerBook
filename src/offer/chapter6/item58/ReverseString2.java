/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter6.item58;

/**
 * 翻转字符串
 *
 * @author xingye
 * @created 2020/9/23
 */
public class ReverseString2 {

    private String reverseString(String target) {
        if (null == target || target.length() < 2) {
            return target;
        }

        char[] chars = target.toCharArray();
        // 整体翻转
        reverseChars(chars, 0, chars.length - 1);
        // 分单词翻转
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ') {
                reverseChars(chars, start, i - 1);
                start = i + 1;
            }
        }
        return new String(chars);
    }

    private void reverseChars(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }

    public static void main(String... args) {
        ReverseString2 reverseString2 = new ReverseString2();
        System.out.println(reverseString2.reverseString(" "));
        System.out.println(reverseString2.reverseString("  "));
        System.out.println(reverseString2.reverseString(" ha ha !"));
        System.out.println(reverseString2.reverseString("a student"));
        System.out.println(reverseString2.reverseString("I am a student."));
        System.out.println(reverseString2.reverseString("With a bit of guidance, anyone can become a Java programmer."));
    }

}