/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item38;

import java.util.ArrayList;
import java.util.List;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/10/8
 */
public class Permutation4 {

    public List<String> permutation(String target) {
        if (null == target || target.length() == 0) {
            return new ArrayList<>();
        }

        List<String> result = new ArrayList<>();
        char[] chars = target.toCharArray();
        permutationCore(chars, 0, result);
        return result;
    }

    private void permutationCore(char[] chars, int index, List<String> result) {
        if (index == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        boolean repeat;
        for (int i = index; i < chars.length; i++) {
            repeat = false;
            for (int j = index; j < i; j++) {
                if (chars[j] == chars[i]) {
                    repeat = true;
                    break;
                }
            }
            if (repeat) {
                continue;
            }

            swap(chars, index, i);
            permutationCore(chars, index + 1, result);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String... args) {
        Permutation4 permutation4 = new Permutation4();
        System.out.println(permutation4.permutation("aac"));
    }

}