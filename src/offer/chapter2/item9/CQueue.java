/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item9;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author xingye
 * @created 2020/7/14
 */
public class CQueue {
    private Stack<Integer> stackForAppend = new Stack<>();
    private Stack<Integer> stackForDelete = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        stackForAppend.add(value);
    }

    public int deleteHead() {
        if (stackForDelete.isEmpty()) {
            if (stackForAppend.isEmpty()) {
                return -1;
            }
            while (!stackForAppend.isEmpty()) {
                stackForDelete.add(stackForAppend.pop());
            }
        }

        return stackForDelete.pop();
    }

}