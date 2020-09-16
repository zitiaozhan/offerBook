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
 * @created 2020/9/16
 */
public class ValidateStackSequences2 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if ((null == pushed && null != popped) || (null != pushed && null == popped)) {
            return false;
        }
        if (pushed == null) {
            return true;
        }
        if (pushed.length != popped.length) {
            return false;
        }

        // 使用栈模拟出栈、入栈序列
        Stack<Integer> numStack = new Stack<>();
        int index = 0;
        for (int popNum : popped) {
            if (!numStack.isEmpty() && numStack.peek() == popNum) {
                // 对应出栈数字，继续下一个出栈序列
                numStack.pop();
                continue;
            }
            // 当前出栈序列不对应，入栈新数字
            while (index < pushed.length && pushed[index] != popNum) {
                numStack.push(pushed[index++]);
            }
            if (index >= pushed.length) {
                return false;
            }
            if (pushed[index] == popNum) {
                // 出栈popNum
                index = index + 1;
            }
        }

        return true;
    }

}