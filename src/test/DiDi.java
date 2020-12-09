/*
 * Copyright (c) 2020 maoyan.com
 * All rights reserved.
 *
 */
package test;

/**
 * 在这里编写类的功能描述
 *
 * @author xingye
 * @created 2020/12/9
 */
public class DiDi {

    private static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public Node ringNodeOrReverse(Node head) {
        if (null == head) {
            return null;
        }

        // 获取环的长度
        int ringLen = getRingLen(head);
        if (ringLen == -1) {
            // 执行链表的翻转
            Node cur = head, pre = null, next = cur.next;
            while (next != null) {
                cur.next = pre;
                pre = cur;
                cur = next;
                next = next.next;
            }
            cur.next = pre;
            return cur;
        }

        Node quick = head, slow = head;
        while (ringLen > 0) {
            quick = quick.next;
            ringLen--;
        }

        while (quick != slow) {
            quick = quick.next;
            slow = slow.next;
        }

        return slow;
    }

    private int getRingLen(Node head) {
        Node quick = head, slow = head;

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
        while (quick != slow) {
            slow = slow.next;
            len++;
        }
        return len;
    }

}