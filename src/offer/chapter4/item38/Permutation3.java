/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author xingye
 * @created 2020/9/26
 */
public class Permutation3 {

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        List<String> result = new ArrayList<>();
        permutationCore(result, chars, 0);
        return result.toArray(new String[]{});
    }

    private void permutationCore(List<String> result, char[] chars, int index) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        HashSet<Character> repeat = new HashSet<>();
        for (int i = index; i < chars.length; i++) {
            if (repeat.contains(chars[i])) {
                continue;
            }
            repeat.add(chars[i]);
            swap(chars, i, index);
            permutationCore(result, chars, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String... args) {
        Permutation3 permutation3 = new Permutation3();
        System.out.println(Arrays.toString(permutation3.permutation("abc")));
        System.out.println(Arrays.toString(permutation3.permutation("abb")));
    }

}