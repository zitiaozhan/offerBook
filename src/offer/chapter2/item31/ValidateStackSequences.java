/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item31;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @author xingye
 * @created 2020/8/1
 */
public class ValidateStackSequences {
    public static void main(String... args) {
        ValidateStackSequences stackSequences = new ValidateStackSequences();
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 1, 5, 3, 2}));
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 2}));
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 4, 5, 2, 3}));
        System.out.println(stackSequences.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{1, 4, 5, 3, 2}));
        System.out.println(stackSequences.validateStackSequences(new int[]{3, 2, 3, 4}, new int[]{3, 4, 2, 3}));
    }

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (null == pushed) {
            return null == popped || 0 == popped.length;
        }
        if (0 == pushed.length && 0 == popped.length) {
            return true;
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // 1.遍历出栈序列
        int pushIndex = 0;
        for (int value : popped) {
            while (pushIndex < pushed.length) {
                if (!stack.isEmpty() && stack.peek() == value) {
                    break;
                }
                stack.push(pushed[pushIndex]);
                if (pushed[pushIndex++] == value) {
                    break;
                }
            }
            if (value != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}