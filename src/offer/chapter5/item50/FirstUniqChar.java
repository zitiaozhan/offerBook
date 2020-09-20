/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item50;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author xingye
 * @created 2020/9/20
 */
public class FirstUniqChar {

    public char firstUniqChar(String s) {
        if (null == s || 0 == s.length()) {
            return ' ';
        }
        char[] chars = s.toCharArray();
        // 模拟哈希表
        int[] counts = new int[26];
        for (char aChar : chars) {
            counts[aChar - 'a']++;
        }
        for (char aChar : chars) {
            if (counts[aChar - 'a'] == 1) {
                return aChar;
            }
        }
        return ' ';
    }

}