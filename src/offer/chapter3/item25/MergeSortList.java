/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item25;

/**
 * 剑指 Offer 25. 合并有序链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * @author xingye
 * @created 2020/7/28
 */
public class MergeSortList {
    public static void main(String... args) {
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(8);
        node1.next = node2;
        ListNode node3 = new ListNode(9);
        node2.next = node3;
        ListNode node4 = new ListNode(10);
        node3.next = node4;
        ListNode node5 = new ListNode(20);
        node4.next = node5;

        ListNode node11 = new ListNode(0);
        ListNode node12 = new ListNode(2);
        node11.next = node12;
        ListNode node13 = new ListNode(6);
        node12.next = node13;
        ListNode node14 = new ListNode(12);
        node13.next = node14;
        ListNode node15 = new ListNode(30);
        node14.next = node15;

        MergeSortList mergeSortList = new MergeSortList();
        System.out.println(mergeSortList.mergeTwoLists(null, node11));
    }

    // O(M+N)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return getMergeHead(l1, l2);
    }

    private ListNode getMergeHead(ListNode l1, ListNode l2) {
        if (null == l1 && null == l2) {
            return null;
        }
        if (null == l1) {
            return l2;
        } else if (null == l2) {
            return l1;
        }

        ListNode head;
        if (l1.val <= l2.val) {
            head = l1;
            head.next = getMergeHead(l1.next, l2);
        } else {
            head = l2;
            head.next = getMergeHead(l1, l2.next);
        }
        return head;
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