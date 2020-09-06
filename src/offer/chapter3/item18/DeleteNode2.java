/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item18;

/**
 * 剑指 Offer 18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 *
 * @author xingye
 * @created 2020/9/6
 */
public class DeleteNode2 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (null == head) {
            return null;
        }

        // 1.该节点为头结点
        if (head.val == val) {
            ListNode next = head.next;
            head.next = null;
            return next;
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (cur.next.val == val) {
                break;
            }
            cur = cur.next;
        }
        // 2.没找到
        if (cur.next == null) {
            return head;
        }
        // 3.节点
        ListNode right = cur.next.next;
        cur.next.next = null;
        cur.next = right;
        return head;
    }
}