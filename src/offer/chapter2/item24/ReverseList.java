/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item24;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author xingye
 * @created 2020/7/28
 */
public class ReverseList {
    public static void main(String... args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;

        ReverseList reverseList=new ReverseList();
        System.out.println(reverseList.reverseList(node1));
    }

    private ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode a = null;
        ListNode b = head;
        ListNode c = head.next;

        while (c != null) {
            // 反转
            b.next = a;
            // 下一个
            ListNode tempC = c;
            a = b;
            b = tempC;
            c = c.next;
        }
        b.next = a;

        return b;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + ", next=" + next + '}';
        }
    }
}