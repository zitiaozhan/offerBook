/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * P197
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * 讲解：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
 *
 * @author xingye
 * @created 2020/8/20
 */
public class Permutation {
    public static void main(String... args) {
        Permutation permutation = new Permutation();
        System.out.println(Arrays.toString(permutation.permutation("acc")));
    }

    public String[] permutation(String target) {
        if (null == target || target.length() == 0) {
            return null;
        }

        List<String> list = new ArrayList<>();
        char[] charArray = target.toCharArray();
        permutation(charArray, 0, list);
        return list.toArray(new String[0]);
    }

    /**
     * DFS依次确定 index 位置的字符
     *
     * @param charArray 字符
     * @param index     位置
     * @param list      收集结果
     */
    private void permutation(char[] charArray, int index, List<String> list) {
        if (index == charArray.length - 1) {
            list.add(new String(charArray));
            return;
        }

        // 检查 index 位置上的重复字符
        Set<Character> checkRepeat = new HashSet<>();

        for (int i = index; i < charArray.length; i++) {
            if (checkRepeat.contains(charArray[i])) {
                continue;
            }
            checkRepeat.add(charArray[i]);
            swapChar(charArray, index, i);
            // 开始排列下一个位置
            permutation(charArray, index + 1, list);
            swapChar(charArray, index, i);
        }
    }

    private void swapChar(char[] charArray, int a, int b) {
        char aChar = charArray[a];
        charArray[a] = charArray[b];
        charArray[b] = aChar;
    }

}