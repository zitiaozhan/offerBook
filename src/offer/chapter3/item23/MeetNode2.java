/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package offer.chapter3.item23;

/**
 * P139
 * 链表中环的入口节点
 *
 * @author xingye
 * @created 2020/9/13
 */
public class MeetNode2 {
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

        MeetNode2 meetNode = new MeetNode2();
        System.out.println(meetNode.getRingEntryNode(node1));
    }

    private ListNode getRingEntryNode(ListNode head) {
        if (null == head) {
            return null;
        }

        int ringLength = getRingLength(head);
        if (ringLength == -1) {
            return null;
        }
        ListNode front = head, behind = head;
        // 1.前指针先走 ringLength 次
        while (ringLength > 0) {
            front = front.next;
            ringLength--;
        }

        // 2.后指针和前指针一块走
        while (front != behind) {
            front = front.next;
            behind = behind.next;
        }
        // 3.找到入环节点
        return front;
    }

    /**
     * 得到环的长度
     */
    private int getRingLength(ListNode head) {
        ListNode quick = head, slow = head;
        // 快的一次走两步，慢的一步
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
        // 统计长度
        int len = 1;
        slow = slow.next;
        while (slow != quick) {
            slow = slow.next;
            len++;
        }
        return len;
    }

    private static class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "ListNode{" + "val=" + val + '}';
        }
    }
}