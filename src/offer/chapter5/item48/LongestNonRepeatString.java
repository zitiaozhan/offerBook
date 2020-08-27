/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item48;

import java.util.Arrays;

/**
 * P236
 * 最长不含重复字符的子字符串
 *
 * @author xingye
 * @created 2020/8/27
 */
public class LongestNonRepeatString {

    private String longestSubString(String target) {
        if (null == target || target.length() == 0) {
            return target;
        }

        // 数组保留字符上次出现在下标位置
        int[] position = new int[26];
        Arrays.fill(position, -1);
        // 转数组
        char[] chars = target.toCharArray();
        int left = 0;
        String result = null;

        // 重复出现位置情况分析
        // 1.上次出现位置 >= left ,则子字符串重新开始计入
        // 2.上次出现位置 < left,则继续计入
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            int lastPos = position[curChar - 'a'];
            // 上次出现判断
            if (lastPos >= left) {
                if (null == result || i - left > result.length()) {
                    result = target.substring(left, i);
                }
                left = i;
            }

            position[curChar - 'a'] = i;
        }
        if (null == result || chars.length - left > result.length()) {
            result = target.substring(left);
        }

        return result;
    }

    private String longestSubString2(String target) {
        if (null == target || target.length() == 0) {
            return target;
        }

        // 数组保留字符上次出现在下标位置
        int[] position = new int[26];
        Arrays.fill(position, -1);
        // 转数组
        char[] chars = target.toCharArray();
        int left = 0;
        int resLeft = 0, resRight = 0;

        // 重复出现位置情况分析
        // 1.上次出现位置 >= left ,则子字符串重新开始计入
        // 2.上次出现位置 < left,则继续计入
        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            int lastPos = position[curChar - 'a'];
            // 上次出现判断
            if (lastPos >= left) {
                if (i - left > (resRight - resLeft + 1)) {
                    resLeft = left;
                    resRight = i - 1;
                }
                left = i;
            }

            position[curChar - 'a'] = i;
        }
        if (chars.length - left > (resRight - resLeft + 1)) {
            resLeft = left;
            resRight = chars.length - 1;
        }

        // Java-substring特性，左闭右开
        return target.substring(resLeft, resRight + 1);
    }

    public static void main(String... args) {
        LongestNonRepeatString nonRepeatString = new LongestNonRepeatString();
        System.out.println(nonRepeatString.longestSubString("arabcacfr"));
        System.out.println(nonRepeatString.longestSubString2("arabcacfr"));
        System.out.println("################");
        System.out.println(nonRepeatString.longestSubString("abcdefghijkb"));
        System.out.println(nonRepeatString.longestSubString2("abcdefghijkb"));
        System.out.println("################");
        System.out.println(nonRepeatString.longestSubString("aaa"));
        System.out.println(nonRepeatString.longestSubString2("aaa"));
        System.out.println("################");
        System.out.println(nonRepeatString.longestSubString("hahahah"));
        System.out.println(nonRepeatString.longestSubString2("hahahah"));
        System.out.println("################");
        System.out.println(nonRepeatString.longestSubString("f"));
        System.out.println(nonRepeatString.longestSubString2("f"));
        System.out.println("################");
        System.out.println(nonRepeatString.longestSubString(""));
        System.out.println(nonRepeatString.longestSubString2(""));
    }
}