/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item6;

import java.util.Arrays;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author xingye
 * @created 2020/7/12
 */
public class ReversePrint {
    public static void main(String... args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        a.next = b;
        ListNode c = new ListNode(3);
        b.next = c;
        System.out.println(Arrays.toString(new ReversePrint().reversePrintImpl(a)));
    }

    public int[] reversePrint(ListNode head) {
        if (null == head) {
            return new int[]{};
        }

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int[] result = new int[len];
        reversePrintImpl(head, result, len - 1);
        return result;
    }

    /**
     * 递归实现，时间复杂度：n
     *
     * @param head
     * @param result
     */
    private void reversePrintImpl(ListNode head, int[] result, int index) {
        if (null == head) {
            return;
        }

        // 递归调用
        reversePrintImpl(head.next, result, index - 1);
        // 结果赋值
        result[index] = head.val;
    }

    /**
     * 使用栈,空间复杂度n
     *
     * @param head
     */
    private int[] reversePrintImpl(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }

        int index = 0;
        int[] result = new int[stack.size()];
        while (!stack.isEmpty()) {
            result[index++] = stack.pop();
        }
        return result;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}