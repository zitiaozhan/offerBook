/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item6;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表翻转打印
 *
 * @author xingye
 * @created 2020/12/7
 */
public class ReversePrint2 {

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    private int[] print(ListNode head) {
        List<Integer> values = new ArrayList<>();
        printCore(head, values);
        int[] res = new int[values.size()];
        int index = 0;
        for (Integer value : values) {
            res[index++] = value;
        }
        return res;
    }

    private void printCore(ListNode head, List<Integer> values) {
        if (null == head) {
            return;
        }

        printCore(head.next, values);
        values.add(head.val);
    }

}