/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter2.item23;


/**
 * 23:链表中环的入口节点
 *
 * @author xingye
 * @created 2020/7/27
 */
public class MeetNode {
    public static void main(String... args) {
        // O(N)
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        node5.next = node2;

        MeetNode meetNode = new MeetNode();
        System.out.println(meetNode.meetNode(node1));
    }

    private ListNode meetNode(ListNode root) {
        if (null == root) {
            return null;
        }

        int len = getLength(root);
        if (-1 == len) {
            return null;
        }

        ListNode quick = root;
        while (len > 0) {
            quick = quick.next;
            len--;
        }

        ListNode slow = root;
        while (slow != quick) {
            slow = slow.next;
            quick = quick.next;
        }
        return slow;
    }

    private int getLength(ListNode root) {
        ListNode quick = root;
        ListNode slow = root;

        while (quick != null && quick.next != null) {
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow) {
                break;
            }
        }

        if (quick != slow) {
            return -1;
        }

        int len = 1;
        slow = slow.next;
        while (slow != quick) {
            slow = slow.next;
            len++;
        }
        return len;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + '}';
        }
    }
}