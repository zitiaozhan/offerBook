/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item22;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
 * 这个链表的倒数第3个节点是值为4的节点。
 *
 * @author xingye
 * @created 2020/7/27
 */
public class GetKthFromEnd {
    public static void main(String... args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;

        GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
        System.out.println(getKthFromEnd.getKthFromEnd(listNode1, 0).val);
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        if (null == head || k < 1) {
            return null;
        }

        // 双指针，pre先走k-1步
        ListNode pre = head;
        ListNode target = head;

        while (k > 1 && pre != null) {
            pre = pre.next;
            k--;
        }
        if (null == pre) {
            return null;
        }

        while (pre.next != null) {
            pre = pre.next;
            target = target.next;
        }
        return target;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}