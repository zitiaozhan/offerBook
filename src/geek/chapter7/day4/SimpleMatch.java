/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day4;

/**
 * 实现朴素的字符串匹配算法
 *
 * @author xingye
 * @created 2020/11/26
 */
public class SimpleMatch {
    public int simpleMatch(String main, String pattern) {
        if (null == main || null == pattern || main.length() < pattern.length()) {
            return -1;
        }

        char[] mainChars = main.toCharArray();
        char[] patternChars = pattern.toCharArray();
        int left = 0, right = 0;
        while (left <= mainChars.length - patternChars.length) {
            int index = right - left;
            if (mainChars[right] != patternChars[index]) {
                right = ++left;
                continue;
            }

            if (index == patternChars.length - 1) {
                return left;
            }
            right++;
        }
        return -1;
    }

    public static void main(String... args) {
        SimpleMatch simpleMatch = new SimpleMatch();
        System.out.println(simpleMatch.simpleMatch("automatic traffic signal light", "signal"));
        System.out.println(simpleMatch.simpleMatch("automatic traffic signal light", "signat"));
        System.out.println(simpleMatch.simpleMatch("automatic traffic signal light", "light"));
        System.out.println(simpleMatch.simpleMatch("automatic traffic signal light", "lighh"));
        System.out.println(simpleMatch.simpleMatch("automatic", "automatic"));
    }
}