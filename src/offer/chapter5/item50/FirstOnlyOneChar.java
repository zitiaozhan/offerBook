/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter5.item50;

import java.util.HashMap;

/**
 * P243
 * 第一个只出现一次的字符
 * 在字符串 s 中找出第一个只出现一次的字符。
 * 如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author xingye
 * @created 2020/8/29
 */
public class FirstOnlyOneChar {

    private Character firstOnlyOneChar1(String target) {
        if (null == target || target.length() == 0) {
            return ' ';
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = target.toCharArray();
        for (char aChar : chars) {
            hashMap.merge(aChar, 1, Integer::sum);
        }
        for (char aChar : chars) {
            if (hashMap.get(aChar) == 1) {
                return aChar;
            }
        }
        return ' ';
    }

    private Character firstOnlyOneChar2(String target) {
        if (null == target || target.length() == 0) {
            return null;
        }

        return null;
    }

    public static void main(String... args) {
        FirstOnlyOneChar onlyOneChar = new FirstOnlyOneChar();
        System.out.println(onlyOneChar.firstOnlyOneChar1("abaccdeff"));
    }

}