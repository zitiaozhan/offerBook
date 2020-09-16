package offer.chapter4.item30;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 30. 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
class MinStack2 {
    private int index;
    private List<Integer> numStack;
    private List<Integer> minStack;

    public MinStack2() {
        index = 0;
        numStack = new ArrayList<>();
        minStack = new ArrayList<>();
    }

    public void push(int x) {
        numStack.add(index, x);
        // 最小栈是否为空
        if (minStack.isEmpty()) {
            minStack.add(index, x);
        } else {
            minStack.add(index, Math.min(x, minStack.get(index - 1)));
        }
        index++;
    }

    public void pop() {
        if (numStack.isEmpty()) {
            return;
        }

        index--;
        numStack.remove(index);
        minStack.remove(index);
    }

    public int top() {
        if (numStack.isEmpty()) {
            throw new IllegalArgumentException("栈已空");
        }
        return numStack.get(index - 1);
    }

    public int min() {
        if (minStack.isEmpty()) {
            throw new IllegalArgumentException("栈已空");
        }
        return minStack.get(index - 1);
    }
}