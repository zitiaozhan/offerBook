/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * DONE: 重做标签
 *
 * @author xingye
 * @created 2020/9/19
 */
public class Permutation2 {

    public String[] permutation(String s) {
        if (null == s) {
            return new String[0];
        }

        char[] chars = s.toCharArray();
        List<String> resList = new ArrayList<>();
        permutationCore(chars, 0, resList);
        return resList.toArray(new String[]{});
    }

    private void permutationCore(char[] chars, int index, List<String> resList) {
        if (index == chars.length - 1) {
            // 最后一位元素已固定，不需要再循环
            resList.add(new String(chars));
            return;
        }

        Set<Character> set = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);

            // 通过交换元素，固定index位置处的字符
            swapChar(chars, i, index);
            permutationCore(chars, index + 1, resList);
            // 使用完字符再通过交换复原数组
            swapChar(chars, i, index);
        }
    }

    private void permutationCore2(char[] chars, int index, List<String> resList) {
        if (index == chars.length - 1) {
            // 最后一位元素已固定，不需要再循环
            resList.add(new String(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            boolean repeat = false;
            for (int j = index; j < i; j++) {
                if (chars[j] == chars[i]) {
                    // 与使用 set含义相同，前面使用过该字符则跳过
                    repeat = true;
                    break;
                }
            }
            if (repeat) {
                continue;
            }

            // 通过交换元素，固定index位置处的字符
            swapChar(chars, i, index);
            permutationCore(chars, index + 1, resList);
            // 使用完字符再通过交换复原数组
            swapChar(chars, i, index);
        }
    }

    private void swapChar(char[] chars, int a, int b) {
        if (a == b || chars[a] == chars[b]) {
            return;
        }
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

}