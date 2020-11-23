/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package geek.chapter7.day2;

import java.util.ArrayList;
import java.util.List;

/**
 * 编程实现斐波那契数列求值 f(n)=f(n-1)+f(n-2)
 * 编程实现求阶乘 n!
 * 编程实现一组数据集合的全排列
 *
 * @author xingye
 * @created 2020/11/23
 */
public class Fibonacci {

    private int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        if (n < 2) {
            return n;
        }
        int n_1 = 1, n_2 = 0;

        int fn = 0;
        for (int i = 2; i <= n; i++) {
            fn = n_1 + n_2;
            n_2 = n_1;
            n_1 = fn;
        }
        return fn;
    }

    private int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    private List<String> allArray(char[] chars) {
        List<String> res = new ArrayList<>();
        allArrayCore(0, chars, res);
        return res;
    }

    private void allArrayCore(int index, char[] chars, List<String> res) {
        if (index == chars.length - 1) {
            res.add(new String(chars));
            return;
        }

        boolean repeat = false;
        for (int i = index; i < chars.length; i++) {
            // 检查重复项
            for (int j = index; j < i; j++) {
                if (chars[i] == chars[j]) {
                    repeat = true;
                    break;
                }
            }
            if (repeat) {
                continue;
            }
            swap(chars, index, i);
            allArrayCore(index + 1, chars, res);
            swap(chars, index, i);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }

    public static void main(String... args) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.allArray(new char[]{'a', 'b', 'c'}));
        System.out.println(fibonacci.allArray(new char[]{'a', 'b', 'a'}));
        System.out.println(fibonacci.allArray(new char[]{'a', 'a', 'a'}));
    }

}