/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter4.item31;

import java.util.Stack;

/**
 * 剑指 Offer 31. 栈的压入、弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，
 * 请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，
 * 但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * @author xingye
 * @created 2020/12/8
 */
public class ValidateStackSequences3 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int pushIndex = 0, popIndex = 0;
        while (popIndex < popped.length || !stack.isEmpty()) {
            while (stack.isEmpty() || stack.peek() != popped[popIndex]) {
                if (pushIndex == pushed.length) {
                    break;
                }
                stack.add(pushed[pushIndex++]);
            }

            if (stack.peek() != popped[popIndex]) {
                return false;
            }

            popIndex++;
            stack.pop();
        }
        return true;
    }

    public static void main(String... args) {
        ValidateStackSequences3 stackSequences3 = new ValidateStackSequences3();
        boolean sequences = stackSequences3.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});
        System.out.println("sequences = " + sequences);
    }

}