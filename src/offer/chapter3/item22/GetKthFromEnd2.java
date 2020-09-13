/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item22;

/**
 * P134
 * 链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
 *
 * @author xingye
 * @created 2020/9/13
 */
public class GetKthFromEnd2 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head || k < 1) {
            return null;
        }

        // 双指针
        ListNode left = head, right = head;
        // right先走k-1步
        while (k > 1) {
            right = right.next;
            if (null == right) {
                throw new IllegalArgumentException("k值过大");
            }
            k--;
        }

        // 一块向下走
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }
        return left;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

}